2024-11-03T00:54:19.834+05:30 DEBUG 3532 --- [learning-kafka-3] [nio-8080-exec-3] c.t.kafka.contoller.EventController      : event reached to EventController: {
"event":"my first event, accpet it peacefully..!"
}
2024-11-03T00:54:19.835+05:30 DEBUG 3532 --- [learning-kafka-3] [nio-8080-exec-3] c.t.kafka.producer.KafkaProducer         : event reached to KafkaProducer: {
"event":"my first event, accpet it peacefully..!"
}
2024-11-03T00:54:19.835+05:30 DEBUG 3532 --- [learning-kafka-3] [nio-8080-exec-3] c.t.k.config.KafkaProducerInterceptor    : Sending record: {
"event":"my first event, accpet it peacefully..!"
}
2024-11-03T00:54:19.841+05:30 DEBUG 3532 --- [learning-kafka-3] [ka-3-producer-1] c.t.k.config.KafkaProducerInterceptor    : event sent successfully. topic: myTopic1
2024-11-03T00:54:19.853+05:30 DEBUG 3532 --- [learning-kafka-3] [ntainer#0-0-C-1] c.t.k.config.KafkaConsumerInterceptor    : Consumed record: {
"event":"my first event, accpet it peacefully..!"
"timestamp:""2024-11-03T00:54:19.836761400"
}, from topic myTopic1
2024-11-03T00:54:19.854+05:30 DEBUG 3532 --- [learning-kafka-3] [ntainer#0-0-C-1] c.t.kafka.consumer.KafkaConsumer         : event reached to KafkaConsumer: {
"event":"my first event, accpet it peacefully..!"
"timestamp:""2024-11-03T00:54:19.836761400"
}
2024-11-03T00:54:19.861+05:30 DEBUG 3532 --- [learning-kafka-3] [ntainer#0-0-C-1] c.t.k.config.KafkaConsumerInterceptor    : Committed offset: 41, for partition: 0, topic: myTopic1
