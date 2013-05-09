package jmotor.ctdog.analysis;

import jmotor.ctdog.core.Transaction;
import jmotor.ctdog.meta.Configuration;

import java.util.List;

/**
 * Component:Concurrent Tester
 * Description:Test result analyser
 * Date: 12-7-17
 *
 * @author Andy.Ai
 */
public interface ResultAnalyser {
    void analysis(Configuration configuration, List<Transaction> transactions);
}
