package com.dincerunal.app;

import com.dincerunal.app.application.SensorReadingProcessorService;
import com.dincerunal.app.domain.port.SensorDataProcessor;
import com.dincerunal.app.infrastructure.KafkaSensorDataConsumer;

public class SensorConsumerApplication {
    public static void main(String[] args) {
        
        SensorDataProcessor processorService = new SensorReadingProcessorService();
        
        KafkaSensorDataConsumer kafkaAdapter = 
            new KafkaSensorDataConsumer(processorService);

        kafkaAdapter.startConsuming();
    }
}