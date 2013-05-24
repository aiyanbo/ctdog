package jmotor.ctdog;

import jmotor.ctdog.analysis.ResultAnalyser;
import jmotor.ctdog.analysis.impl.ResultAnalyserImpl;
import jmotor.ctdog.core.Runner;
import jmotor.ctdog.core.Transaction;
import jmotor.ctdog.core.impl.ScheduledExecutorRunner;
import jmotor.ctdog.generator.ConfigurationGenerator;
import jmotor.ctdog.generator.impl.ConfigurationGeneratorImpl;
import jmotor.ctdog.meta.Configuration;

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
    private ConfigurationGenerator configurationGenerator = new ConfigurationGeneratorImpl();

    @Override
    public void start(String... arguments) throws Exception {
        Configuration configuration = configurationGenerator.generateConfiguration(arguments);
        List<Transaction> transactions = runner.runAction(configuration);
        resultAnalyser.analysis(configuration, transactions);
    }

    public void setRunner(Runner runner) {
        this.runner = runner;
    }

    public void setResultAnalyser(ResultAnalyser resultAnalyser) {
        this.resultAnalyser = resultAnalyser;
    }

    public void setConfigurationGenerator(ConfigurationGenerator configurationGenerator) {
        this.configurationGenerator = configurationGenerator;
    }
}
