package com.example.springkafkahelloworld.service;

import com.example.springkafkahelloworld.message.RandomClassObjectDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class KafkaConsumer {

    @KafkaListener(topics = "hello-world-kafka-topic", containerFactory = "kafkaListenerContainerFactory", groupId = "hello-world-group")
    public void handleOrganizationCreated(RandomClassObjectDto data) {
        log.info("Start processing kafka data {}", data);
    }
}
