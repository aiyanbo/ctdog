package jmotor.ctdog;

import jmotor.ctdog.analysis.ResultAnalyser;
import jmotor.ctdog.analysis.impl.ResultAnalyserImpl;
import jmotor.ctdog.core.Runner;
import jmotor.ctdog.core.Transaction;
import jmotor.ctdog.generator.ConfigurationGenerator;
import jmotor.ctdog.generator.impl.ConfigurationGeneratorImpl;
import jmotor.ctdog.core.impl.ScheduledExecutorRunner;
import jmotor.ctdog.meta.Configuration;

import java.util.List;

/**
 * Component:Concurrent Tester
 * Description:Concurrent Test Dog (main implementation)
 * Date: 12-7-17
 *
 * @author Andy.Ai
 */
public class CTDog {
    private static Runner runner = new ScheduledExecutorRunner();
    private static ResultAnalyser resultAnalyser = new ResultAnalyserImpl();
    private static ConfigurationGenerator configurationGenerator = new ConfigurationGeneratorImpl();

    public static void main(String[] args) throws ClassNotFoundException, InterruptedException {
        Configuration configuration = configurationGenerator.generateConfiguration(args);
        List<Transaction> transactions = runner.runAction(configuration);
        resultAnalyser.analysis(configuration, transactions);
    }

}
