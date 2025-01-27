package com.extra_startup_exercise.service;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Service;

import java.util.concurrent.ArrayBlockingQueue;

@Service
public class MonitoredQueueFactory {

    private final MeterRegistry meterRegistry;

    public MonitoredQueueFactory(MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;
    }

    public <T> ArrayBlockingQueue<T> create(String name, int capacity) {
        ArrayBlockingQueue<T> queue = new ArrayBlockingQueue<>(capacity);

        meterRegistry.gauge("queue.%s.utilization".formatted(name),
                queue,
                value -> ((double)value.size() / (double)capacity) * 100.0);

        return queue;
    }
}
