package jmotor.ctdog;

import junit.framework.TestCase;

/**
 * Component:
 * Description:
 * Date: 13-5-25
 *
 * @author Andy Ai
 */
public class LauncherTest extends TestCase {
    public void test() throws Exception {
        CTDogLauncher launcher = new CTDogLauncherImpl();
        launcher.start("-a", "jmotor.ctdog.TestAction",
                "-c", "10",
                "-t", "1000",
                "-d", "1000",
                "-p", "name,Andy");
    }
}
