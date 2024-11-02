package com.techwithvishal.kafka.config;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class TopicConfig {

    private String myTopic = "myTopic1";
}
