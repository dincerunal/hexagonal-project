package com.dincerunal.app.domain.port;

import com.dincerunal.app.domain.SensorReading;

public interface SensorDataProcessor {
    void process(SensorReading reading);
}