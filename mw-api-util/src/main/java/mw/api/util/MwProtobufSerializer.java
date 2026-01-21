package mw.api.util;

import com.google.protobuf.MessageLite;
import org.apache.kafka.common.serialization.Serializer;
import java.util.Map;

public class MwProtobufSerializer<T extends MessageLite> implements Serializer<T> {
    @Override
    public byte[] serialize(String topic, T data) {
        if (data == null) {
            return null;
        }
        return data.toByteArray(); 
    }
    @Override public void configure(Map<String, ?> configs, boolean isKey) {}
    @Override public void close() {}
}