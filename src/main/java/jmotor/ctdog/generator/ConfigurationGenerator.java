package jmotor.ctdog.generator;

import jmotor.ctdog.meta.Configuration;

/**
 * Component:Concurrent Tester
 * Description:Commands configuration generator
 * Date: 12-7-17
 *
 * @author Andy.Ai
 */
public interface ConfigurationGenerator {
    Configuration generateConfiguration(String[] commands) throws ClassNotFoundException;
}
