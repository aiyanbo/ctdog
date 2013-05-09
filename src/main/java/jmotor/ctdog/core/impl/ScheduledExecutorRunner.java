package jmotor.ctdog.core.impl;

import jmotor.ctdog.core.Action;
import jmotor.ctdog.core.Runner;
import jmotor.ctdog.core.Transaction;
import jmotor.ctdog.meta.Configuration;
import jmotor.ctdog.utils.BasicUtils;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Component:Concurrent Tester
 * Description:Scheduled executor runner
 * Date: 12-7-17
 *
 * @author Andy.Ai
 */
public class ScheduledExecutorRunner implements Runner {
    private static Logger logger = Logger.getLogger(ScheduledExecutorRunner.class);

    @Override
    public List<Transaction> runAction(Configuration configuration) throws InterruptedException {
        logger.debug("test case initializing...");
        int runs = (int) (configuration.getDuration() / 1000);
        int actionCount = configuration.getConcurrent() * runs;
        List<Action> actions = new ArrayList<Action>(actionCount);
        List<Transaction> transactions = new ArrayList<Transaction>(actionCount);
        for (int i = 0; i < actionCount; i++) {
            Action action = BasicUtils.newInstance(configuration.getAction());
            Transaction transaction = new TransactionImpl();
            action.setTransaction(transaction);
            action.init(configuration.getParameters());
            actions.add(action);
            transactions.add(transaction);
        }
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(actionCount);
        long runningTime = (System.currentTimeMillis() + actionCount * configuration.getIndex() + 1000) / 1000 * 1000;
        logger.debug("test case will be start running in: " + BasicUtils.defaultFormatDate(runningTime));
        int actionIndex = 0;
        for (int runIndex = 0; runIndex < runs; runIndex++) {
            long currentRunningTime = runningTime + runIndex * 1000;
            for (int subActionIndex = 0; subActionIndex < configuration.getConcurrent(); subActionIndex++) {
                executorService.schedule(actions.get(actionIndex++), currentRunningTime - System.currentTimeMillis(),
                        TimeUnit.MILLISECONDS);
            }
        }
        logger.debug("test case prepared running in: " + BasicUtils.defaultFormatDate(System.currentTimeMillis()));
        executorService.shutdown();
        while (!executorService.isTerminated()) {
            Thread.sleep(1000);
        }
        for (Action action : actions) {
            action.end(configuration.getParameters());
        }
        logger.debug("test case finished in: " + BasicUtils.defaultFormatDate(System.currentTimeMillis()));
        return transactions;
    }

}

