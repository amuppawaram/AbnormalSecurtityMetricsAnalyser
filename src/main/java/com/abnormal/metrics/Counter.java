package com.abnormal.metrics;

public class Counter {
    // TODO yet to implement the Metrics Collector
    // private final MetricsCollector collector;
    private final String name = null;
    private Labels labels;
    // TODO Implement MetricsCollector and pass into the Counter
/*
    public Counter(MetricsCollector collector, String name, Labels labels) {
        this.collector = collector;
        this.name = name;
        this.labels = labels;
    }*/
// Increment the counter by 1
    public void increment() {
        increment(1);
    }
// Increment the counter and record it into the collector
    public void increment(int value) {
        //collector.recordMetric(name, labels, value);
    }
    public Counter withLabel(String name, String value) {
        this.labels = labels.withLabel(name, value);
        return this;
    }
}