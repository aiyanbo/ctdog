package org.ctdog.core.impl;

import org.ctdog.core.Transaction;

/**
 * Component:Concurrent Tester
 * Description:Transaction implementation
 * Date: 12-7-17
 *
 * @author Andy.Ai
 */
public class TransactionImpl implements Transaction {
    private Long beginTime;
    private Long endTime;
    private String name;

    @Override
    public void begin() {
        beginTime = System.currentTimeMillis();
    }

    @Override
    public void end() {
        endTime = System.currentTimeMillis();
    }

    @Override
    public void begin(String name) {
        this.name = name;
        begin();
    }

    @Override
    public void end(String name) {
        if (this.name.equals(name)) {
            end();
        }
        throw new IllegalArgumentException("Transaction name is not correct, original name: " + this.name);
    }

    @Override
    public Long getCost() {
        return endTime - beginTime;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Long getBeginTime() {
        return beginTime;
    }

    @Override
    public Long getEndTime() {
        return endTime;
    }
}
