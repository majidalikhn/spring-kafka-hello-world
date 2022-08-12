package com.example.springkafkahelloworld.service;

import com.example.springkafkahelloworld.message.RandomClassObjectDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class KafkaConsumer {

    private final ObjectMapper objectMapper;

    public KafkaConsumer(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @KafkaListener(topics = "hello-world-kafka-topic", containerFactory = "kafkaListenerContainerFactory", groupId = "hello-world-group")
    public void handleOrganizationCreated(String data) throws JsonProcessingException {
        RandomClassObjectDto randomClassObjectDto = objectMapper.readValue(data, RandomClassObjectDto.class);
        log.info("Start processing kafka data {}", randomClassObjectDto);
    }
}
