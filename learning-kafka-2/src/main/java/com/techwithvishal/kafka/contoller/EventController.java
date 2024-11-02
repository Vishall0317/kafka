package com.techwithvishal.kafka.contoller;

import com.techwithvishal.kafka.producer.KafkaProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
@Slf4j
public class EventController {

    @Autowired
    KafkaProducer kafkaProducer;

    @PostMapping("/send")
    public void sendEventToKafka(@RequestBody String event){
        log.debug("event reached to controller: {}", event);
        kafkaProducer.sendEvent(event);
    }
}
