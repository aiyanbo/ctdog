package jmotor.ctdog.meta;

import jmotor.ctdog.core.Action;

import java.util.Map;

/**
 * Component:Concurrent Tester
 * Description:Configuration meta
 * Date: 12-7-17
 *
 * @author Andy.Ai
 */
public class Configuration {
    private Integer concurrent;
    private Long duration = 1000L;
    private Integer timeout = 1000;
    private Integer index = 5;
    private Class<Action> action;
    private Map<String, Object> parameters;

    public Integer getConcurrent() {
        return concurrent;
    }

    public void setConcurrent(Integer concurrent) {
        this.concurrent = concurrent;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public Integer getTimeout() {
        return timeout;
    }

    public void setTimeout(Integer timeout) {
        this.timeout = timeout;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public Class<Action> getAction() {
        return action;
    }

    public void setAction(Class<Action> action) {
        this.action = action;
    }

    public Map<String, Object> getParameters() {
        return parameters;
    }

    public void setParameters(Map<String, Object> parameters) {
        this.parameters = parameters;
    }
}
