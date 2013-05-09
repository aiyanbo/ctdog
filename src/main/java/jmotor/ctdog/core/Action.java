package jmotor.ctdog.core;

import java.util.Map;

/**
 * Component:Concurrent Tester
 * Description:Test action
 * Date: 12-7-17
 *
 * @author Andy.Ai
 */
public interface Action extends Runnable {
    void init(Map<String, String> parameters);

    void end(Map<String, String> parameters);

    Transaction getTransaction();

    void setTransaction(Transaction transaction);
}
