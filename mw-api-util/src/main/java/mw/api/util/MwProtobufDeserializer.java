package mw.api.util;

import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import org.apache.kafka.common.serialization.Deserializer;
import java.util.Map;

public class MwProtobufDeserializer<T extends com.google.protobuf.Message> implements Deserializer<T> {

    private final Parser<T> parser;

    public MwProtobufDeserializer(Parser<T> parser) {
        this.parser = parser;
    }
    
    @SuppressWarnings("unchecked")
    public MwProtobufDeserializer() {
        this.parser = null; 
    }

    @Override
    public T deserialize(String topic, byte[] data) {
        if (data == null || parser == null) {
            return null;
        }
        try {
            return parser.parseFrom(data);
        } catch (InvalidProtocolBufferException e) {
            throw new RuntimeException("Mw-API Deserialization hatası.", e);
        }
    }
    @Override public void configure(Map<String, ?> configs, boolean isKey) {}
    @Override public void close() {}
}