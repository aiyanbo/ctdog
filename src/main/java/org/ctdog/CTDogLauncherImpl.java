package org.ctdog;

import org.ctdog.analysis.ResultAnalyser;
import org.ctdog.analysis.impl.ResultAnalyserImpl;
import org.ctdog.callback.ConfigurationCallback;
import org.ctdog.core.Runner;
import org.ctdog.core.Transaction;
import org.ctdog.core.impl.ScheduledExecutorRunner;
import org.ctdog.generator.ConfigurationGenerator;
import org.ctdog.generator.impl.ConfigurationGeneratorImpl;
import org.ctdog.meta.Configuration;

import java.util.List;

/**
 * Component:
 * Description:
 * Date: 13-5-25
 *
 * @author Andy Ai
 */
public class CTDogLauncherImpl implements CTDogLauncher {
    private Runner runner = new ScheduledExecutorRunner();
    private ResultAnalyser resultAnalyser = new ResultAnalyserImpl();
    private ConfigurationCallback configurationCallback;
    private ConfigurationGenerator configurationGenerator = new ConfigurationGeneratorImpl();

    @Override
    public void start(String... arguments) throws Exception {
        Configuration configuration = configurationGenerator.generateConfiguration(arguments);
        if (null != configurationCallback) {
            configurationCallback.setting(configuration);
        }
        List<Transaction> transactions = runner.runAction(configuration);
        resultAnalyser.analysis(configuration, transactions);
    }

    public void setRunner(Runner runner) {
        this.runner = runner;
    }

    public void setResultAnalyser(ResultAnalyser resultAnalyser) {
        this.resultAnalyser = resultAnalyser;
    }

    public void setConfigurationCallback(ConfigurationCallback configurationCallback) {
        this.configurationCallback = configurationCallback;
    }

    public void setConfigurationGenerator(ConfigurationGenerator configurationGenerator) {
        this.configurationGenerator = configurationGenerator;
    }
}
