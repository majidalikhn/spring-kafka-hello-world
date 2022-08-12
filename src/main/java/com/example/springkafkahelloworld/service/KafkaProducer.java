package com.example.springkafkahelloworld.service;

import com.example.springkafkahelloworld.message.RandomClassObjectDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;

    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate, ObjectMapper objectMapper) {
        this.kafkaTemplate = kafkaTemplate;
        this.objectMapper = objectMapper;
    }

    public void send(RandomClassObjectDto dto) throws Exception {
        String message = createKafkaMessage(dto);
        String key = dto.getRequestId();
        kafkaTemplate.send("hello-world-kafka-topic", key, message);
    }

    private String createKafkaMessage(RandomClassObjectDto dto) throws Exception {
        try {
            return objectMapper.writeValueAsString(dto);
        } catch (JsonProcessingException e) {
            throw new Exception(e);
        }
    }
}
