package com.techwithvishal.kafka.consumer;

import com.techwithvishal.kafka.config.TopicConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaConsumer {

    @Autowired
    TopicConfig topicConfig;

    @KafkaListener(topics = "myTopic1", groupId = "myGroupId1")
    public void consumeEvent(String event){
        log.debug("event reached to KafkaConsumer: {}", event);
    }
}
