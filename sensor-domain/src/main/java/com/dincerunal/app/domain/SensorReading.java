package com.dincerunal.app.domain;

public record SensorReading(
    String id, 
    double temperature, 
    long timestamp) {
        
    public SensorReading {
        if (temperature < 0) {
            throw new IllegalArgumentException("Temperature can't be negative!");
        }
    }
}