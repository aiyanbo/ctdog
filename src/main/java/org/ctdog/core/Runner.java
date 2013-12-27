package org.ctdog.core;

import org.ctdog.meta.Configuration;

import java.util.List;

/**
 * Component:Concurrent Tester
 * Description:Test action runner
 * Date: 12-7-17
 *
 * @author Andy.Ai
 */
public interface Runner {
    List<Transaction> runAction(Configuration configuration) throws InterruptedException;
}
