package jmotor.ctdog.core;

/**
 * Component:Concurrent Tester
 * Description:Test transaction
 * Date: 12-7-17
 *
 * @author Andy.Ai
 */
public interface Transaction {
    void begin();

    void end();

    void begin(String name);

    void end(String name);

    Long getCost();

    String getName();

    Long getBeginTime();

    Long getEndTime();
}
