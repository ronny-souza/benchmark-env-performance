package br.com.rmsa.benchmark.model;

import org.apache.commons.lang3.time.DurationFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StopWatch {

    private static final Logger LOGGER = LoggerFactory.getLogger(StopWatch.class);
    private final long startTime;

    public StopWatch() {
        this.startTime = System.currentTimeMillis();
    }

    public synchronized void getExecutionTime(String context) {
        LOGGER.info("{}: {}", context, this.getExecutionTime());
    }

    private String getExecutionTime() {
        long executionTime = System.currentTimeMillis() - this.startTime;
        return DurationFormatUtils.formatDuration(executionTime, "HH:mm:ss");
    }
}
