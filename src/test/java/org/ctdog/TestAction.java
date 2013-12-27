package org.ctdog;

import org.ctdog.core.Action;
import org.ctdog.core.Transaction;

import java.util.Map;

/**
 * Component:
 * Description:
 * Date: 13-5-25
 *
 * @author Andy Ai
 */
public class TestAction implements Action {
    private Transaction transaction;

    @Override
    public void init(Map<String, Object> parameters) {
        for (String key : parameters.keySet()) {
            System.out.println("key: " + key + "\t" + "value: " + parameters.get(key));
        }
    }

    @Override
    public void end(Map<String, Object> parameters) {

    }

    @Override
    public Transaction getTransaction() {
        return transaction;
    }

    @Override
    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    @Override
    public void run() {
        transaction.begin();
        System.out.println("Running...");
        transaction.end();
    }
}
