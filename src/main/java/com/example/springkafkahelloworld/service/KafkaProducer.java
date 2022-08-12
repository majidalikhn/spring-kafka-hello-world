package com.example.springkafkahelloworld.service;

import com.example.springkafkahelloworld.message.RandomClassObjectDto;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducer {

    private final KafkaTemplate<String, RandomClassObjectDto> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, RandomClassObjectDto> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(RandomClassObjectDto dto) {
        String key = dto.getRequestId();
        kafkaTemplate.send("hello-world-kafka-topic", key, dto);
    }
}
