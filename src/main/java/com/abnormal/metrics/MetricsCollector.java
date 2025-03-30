package com.abnormal.metrics;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MetricsCollector {
    protected final Map<MetricKey, Integer> metrics = new HashMap<>();
    protected final String prefix;

    public MetricsCollector() {
        this("");
    }

    protected MetricsCollector(String prefix) {
        this.prefix = prefix;
    }

    public Counter createCounter(String name, String description, Labels labels) {
        String fullName = prefix.isEmpty() ? name : prefix + ":" + name;
        return new Counter(this, fullName, labels);
    }

    public MetricsCollector createScope(String scopeName) {
        // Yet to implement
        // return new ScopedMetricsCollector(this, scopeName);
        return null;
    }

    public Map<MetricKey, Integer> getMetrics() {
        return Collections.unmodifiableMap(new HashMap<>(metrics));
    }

    protected void recordMetric(String name, Labels labels, int value) {
        synchronized (metrics) {
            metrics.merge(new MetricKey(name, labels), value, Integer::sum);
        }
    }
}