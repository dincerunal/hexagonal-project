package com.dincerunal.app.application;

import com.dincerunal.app.domain.SensorReading;
import com.dincerunal.app.domain.port.SensorDataProcessor;

public class SensorReadingProcessorService implements SensorDataProcessor {
    
    @Override
    public void process(SensorReading reading) {        
        // domain object is processed
        if (reading.temperature() > 24.0) {            
            System.out.printf("!!! WARNING: %s High temprature was reported (%s°C). It is being processed ...%n", 
                reading.id(), reading.temperature());
        } else {
            System.out.printf("processed: Sensor Id: %s, Temperature: %.2f°C%n", 
                reading.id(), reading.temperature());
        }
    }
}