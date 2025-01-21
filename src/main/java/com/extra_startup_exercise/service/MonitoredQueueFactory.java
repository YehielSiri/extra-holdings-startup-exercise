package com.extra_startup_exercise.service;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.stereotype.Component;

import java.util.concurrent.ArrayBlockingQueue;

@Component
//@RequiredArgsConstructor
public class MonitoredQueueFactory {

    private MeterRegistry meterRegistry;

    public <T> ArrayBlockingQueue<T> create(String name, int capacity) {
        ArrayBlockingQueue<T> queue = new ArrayBlockingQueue<>(capacity);

        meterRegistry.gauge("queue.%s.utilization".formatted(name),
                queue,
                value -> ((double)value.size() / (double)capacity) * 100.0);

        return queue;
    }
}
