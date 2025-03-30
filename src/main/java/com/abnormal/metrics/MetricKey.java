package com.abnormal.metrics;

public class MetricKey {
    private final String name;
    private final Labels labels;

    public MetricKey(String name, Labels labels) {
        this.name = name;
        this.labels = labels;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MetricKey)) return false;
        MetricKey other = (MetricKey) o;
        return name.equals(other.name) && labels.equals(other.labels);
    }

    @Override
    public int hashCode() {
        return 31 * name.hashCode() + labels.hashCode();
    }
}