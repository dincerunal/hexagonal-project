package com.dincerunal.app.domain.port;

import com.dincerunal.app.domain.SensorReading;

public interface SensorDataPublisher {
    void publish(SensorReading reading);
}