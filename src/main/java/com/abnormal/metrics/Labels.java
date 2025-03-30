package com.abnormal.metrics;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Labels {
    private final Map<String, String> labels;

    private Labels(Map<String, String> labels) {
        this.labels = Collections.unmodifiableMap(new HashMap<>(labels));
    }

    public static Labels createEmpty() {
        return new Labels(new HashMap<>());
    }

    public static Labels withNames(String... names) {
        Map<String, String> labels = new HashMap<>();
        for (String name : names) {
            labels.put(name, "");
        }
        return new Labels(labels);
    }

    public Labels withLabel(String name, String value) {
        Map<String, String> newLabels = new HashMap<>(labels);
        newLabels.put(name, value);
        return new Labels(newLabels);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Labels)) return false;
        return labels.equals(((Labels) o).labels);
    }

    @Override
    public int hashCode() {
        return labels.hashCode();
    }
}