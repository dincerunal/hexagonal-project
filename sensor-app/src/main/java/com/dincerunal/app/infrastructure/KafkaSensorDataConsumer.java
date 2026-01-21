package com.dincerunal.app.infrastructure;

import com.dincerunal.app.domain.SensorReading;
import com.dincerunal.app.domain.port.SensorDataProcessor;
import com.dincerunal.app.SensorDataMessage; // protobuf Class 
import mw.api.util.MwSensorDataDeserializer; // mv-api library


import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

public class KafkaSensorDataConsumer {
    
    private static final String BOOTSTRAP_SERVERS = "localhost:9092"; 
    private final KafkaConsumer<String, SensorDataMessage> consumer;
    private final SensorDataProcessor processorPort;
    private static final String TOPIC = "sensor-data-topic";

    public KafkaSensorDataConsumer(SensorDataProcessor processorPort) {
        Properties props = new Properties();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "protobuf-hexagonal-group");
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, MwSensorDataDeserializer.class.getName()); // using mw-api
        
        this.consumer = new KafkaConsumer<>(props);
        this.processorPort = processorPort;
        this.consumer.subscribe(Collections.singletonList(TOPIC));
    }
    
    public void startConsuming() {
        System.out.println("Consumer is started, waiting messages...");
        while (true) {
            ConsumerRecords<String, SensorDataMessage> records = consumer.poll(Duration.ofMillis(100));
            records.forEach(record -> {
                SensorDataMessage protobufData = record.value();
                
                // Convert object protobuf to domain
                SensorReading reading = new SensorReading(
                    protobufData.getSensorId(),
                    protobufData.getTemperature(),
                    protobufData.getTimestamp()
                );
                
                processorPort.process(reading);
            });
        }
    }
}