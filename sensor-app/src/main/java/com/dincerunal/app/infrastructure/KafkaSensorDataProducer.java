package com.dincerunal.app.infrastructure;

import com.dincerunal.app.domain.SensorReading;
import com.dincerunal.app.domain.port.SensorDataPublisher;
import com.dincerunal.app.SensorDataMessage; // protobuf Class 
import mw.api.util.MwProtobufSerializer; // mv-api library

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import java.util.Properties;

public class KafkaSensorDataProducer implements SensorDataPublisher, AutoCloseable {
    
    private static final String BOOTSTRAP_SERVERS = "localhost:9092"; 
    private static final String TOPIC = "sensor-data-topic";

    private final KafkaProducer<String, SensorDataMessage> producer;

    public KafkaSensorDataProducer() {
        Properties props = new Properties();
        props.put("bootstrap.servers", BOOTSTRAP_SERVERS);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", MwProtobufSerializer.class.getName()); // using MW-API
        this.producer = new KafkaProducer<>(props);
    }

    @Override
    public void publish(SensorReading reading) {
        // Convert object from Domain to Protobuf 
        SensorDataMessage protobufData = SensorDataMessage.newBuilder()
                .setSensorId(reading.id())
                .setTemperature(reading.temperature())
                .setTimestamp(reading.timestamp())
                .build();
        
        ProducerRecord<String, SensorDataMessage> record = 
            new ProducerRecord<>(TOPIC, reading.id(), protobufData);
        
        producer.send(record, (metadata, exception) -> {
            if (exception != null) {                
                System.err.println("Kafka reference exception : " + exception.getMessage());
            }
        });
    }

    @Override
    public void close() {
        if (producer != null) {
            producer.close();
        }
        
    }
}