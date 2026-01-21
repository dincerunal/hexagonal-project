package com.dincerunal.app;

import com.dincerunal.app.domain.SensorReading;
import com.dincerunal.app.domain.port.SensorDataPublisher;
import com.dincerunal.app.infrastructure.KafkaSensorDataProducer;

public class SensorProducerApplication {
    public static void main(String[] args) throws InterruptedException {
        
        try (KafkaSensorDataProducer kafkaAdapter = new KafkaSensorDataProducer()) {
            
            SensorDataPublisher publisherPort = kafkaAdapter; 
            
            for (int i = 1; i <= 5; i++) {
                SensorReading reading = new SensorReading(
                    "SNSR-DDD-" + i, 
                    22.0 + i * 0.5, 
                    System.currentTimeMillis()
                );
                
                publisherPort.publish(reading); 
                Thread.sleep(1500);
            }
        }
    }
}