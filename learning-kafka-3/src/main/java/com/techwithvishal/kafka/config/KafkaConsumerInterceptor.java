package com.techwithvishal.kafka.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerInterceptor;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.OffsetAndMetadata;
import org.apache.kafka.common.TopicPartition;

import java.util.Map;

@Slf4j
public class KafkaConsumerInterceptor implements ConsumerInterceptor<String, String> {

    @Override
    public ConsumerRecords<String, String> onConsume(ConsumerRecords<String, String> consumerRecords) {
        // Log each record consumed
        consumerRecords.forEach(record ->
                log.debug("Consumed record: " + record.value() + ", from topic " + record.topic())
        );

        // Optionally filter out records (for example, discard records with null values)
        // Note: Filtering should be done carefully to avoid message loss.
        return consumerRecords;
    }

    @Override
    public void onCommit(Map<TopicPartition, OffsetAndMetadata> map) {
        // Log the offsets that are committed
        map.forEach((tp, offset) ->
                log.debug("Committed offset: " + offset.offset()
                        + ", for partition: " + tp.partition()
                        + ", topic: " + tp.topic()));
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
