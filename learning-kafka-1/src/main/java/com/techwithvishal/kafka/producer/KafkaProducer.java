package com.techwithvishal.kafka.producer;

import com.techwithvishal.kafka.config.TopicConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaProducer {

    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    TopicConfig topicConfig;

    public void sendEvent(String event){
        log.debug("event reached to producer: {}", event);
        kafkaTemplate.send(topicConfig.getMyTopic(), event);
        log.debug("send event to topic: {}", topicConfig.getMyTopic());
    }
}
