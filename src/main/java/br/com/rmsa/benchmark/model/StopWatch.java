package br.com.rmsa.benchmark.model;

import org.apache.commons.lang3.time.DurationFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;

public class StopWatch {
    private static final Logger LOGGER = LoggerFactory.getLogger(StopWatch.class);
    private final long startTime;
    private final LocalDateTime startedAt;

    public StopWatch() {
        this.startTime = System.currentTimeMillis();
        this.startedAt = LocalDateTime.now();
    }

    public synchronized void getExecutionTime(String context) {
        LOGGER.info("{}: {}", context, this.getExecutionTime());
    }

    private String getExecutionTime() {
        long executionTime = System.currentTimeMillis() - this.startTime;
        LOGGER.info("STARTED AT: {}", this.getStartedAt());
        LOGGER.info("END AT: {}", LocalDateTime.now());
        return DurationFormatUtils.formatDuration(executionTime, "HH:mm:ss");
    }

    public LocalDateTime getStartedAt() {
        return startedAt;
    }
}
