package com.techwithvishal.kafka.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerInterceptor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Map;

@Slf4j
public class KafkaProducerInterceptor implements ProducerInterceptor<String, String> {

    @Override
    public ProducerRecord<String, String> onSend(ProducerRecord<String, String> producerRecord) {
        //Intercept the record before sending
        log.debug("Sending record: {}", producerRecord.value());

        //U can also modify the record if needed
        String timestamp = String.valueOf(LocalDateTime.now());
        String modifiedValue = producerRecord.value().replaceAll("}", "    \"timestamp:\"\""+timestamp+"\"\n"+"}");
        return new ProducerRecord<>(producerRecord.topic(),
                producerRecord.partition(),
                producerRecord.key(),
                modifiedValue);
    }

    @Override
    public void onAcknowledgement(RecordMetadata recordMetadata, Exception exception) {
        //log the acknowledgement
        if (recordMetadata != null) {
            log.debug("event sent successfully. topic: {}", recordMetadata.topic());
        }
        if (exception != null) {
            log.error("event failed to sent. exception: {}", exception.getMessage());
        }
    }

    @Override
    public void close() {
        //Clean up resources, if any
    }

    @Override
    public void configure(Map<String, ?> map) {
        //Configure the Interceptor
    }
}
