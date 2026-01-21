package mw.api.util;
//package main.java.mw.api.util;

import com.dincerunal.app.SensorDataMessage; 

public class MwSensorDataDeserializer extends MwProtobufDeserializer<SensorDataMessage> {
    public MwSensorDataDeserializer() {
        super(SensorDataMessage.parser()); 
    }
}