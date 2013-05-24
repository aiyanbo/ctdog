package jmotor.ctdog.analysis.impl;

import jmotor.ctdog.analysis.ResultAnalyser;
import jmotor.ctdog.core.Transaction;
import jmotor.ctdog.meta.Configuration;
import jmotor.ctdog.utils.BasicUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * Component:Concurrent Tester
 * Description:Test result analysis stdout implementation
 * Date: 12-7-17
 *
 * @author Andy.Ai
 */
public class ResultAnalyserImpl implements ResultAnalyser {
    @Override
    public void analysis(Configuration configuration, List<Transaction> transactions) {
        Collections.sort(transactions, new Comparator<Transaction>() {
            @Override
            public int compare(Transaction o1, Transaction o2) {
                return (int) (o1.getCost() - o2.getCost());
            }
        });
        SortedMap<String, Integer> runningMapper = new ConcurrentSkipListMap<String, Integer>();
        List<Long> timeoutList = new ArrayList<Long>();
        int timeoutCost = 0;
        int cost = 0;
        for (Transaction transaction : transactions) {
            cost += transaction.getCost();
            if (transaction.getCost() > configuration.getTimeout()) {
                timeoutCost += transaction.getCost();
                timeoutList.add(transaction.getCost());
            }
            putRunningEntry(runningMapper, transaction.getBeginTime());
        }
        System.out.println("============ Test Information ===========");
        System.out.println("Action    : " + configuration.getAction());
        System.out.println("Concurrent: " + configuration.getConcurrent());
        System.out.println("Duration  : " + configuration.getDuration());
        System.out.println("Timeout   : " + configuration.getTimeout());
        System.out.println("============ Cost Information ===========");
        System.out.println("Min: " + transactions.get(0).getCost());
        System.out.println("Max: " + transactions.get(transactions.size() - 1).getCost());
        System.out.println("Avg: " + cost * 1.0 / transactions.size());
        if (timeoutList.size() > 0) {
            System.out.println("========== Timeout Information ==========");
            System.out.println("Size: " + timeoutList.size());
            System.out.println("Min : " + timeoutList.get(0));
            System.out.println("Max : " + timeoutList.get(timeoutList.size() - 1));
            System.out.println("Avg : " + timeoutCost * 1.0 / timeoutList.size());
        }
        System.out.println("========== Running Information ==========");
        for (String key : runningMapper.keySet()) {
            System.out.println("Time: " + key + "\t Count: " + runningMapper.get(key));
        }
    }

    private void putRunningEntry(Map<String, Integer> runningMapper, long runningTime) {
        String formatDate = BasicUtils.defaultFormatDate(runningTime);
        Integer count = runningMapper.get(formatDate);
        if (count == null) {
            count = 1;
        } else {
            count++;
        }
        runningMapper.put(formatDate, count);
    }
}
