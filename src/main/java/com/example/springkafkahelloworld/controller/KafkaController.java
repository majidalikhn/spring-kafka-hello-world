package com.example.springkafkahelloworld.controller;

import com.example.springkafkahelloworld.message.RandomClassObjectDto;
import com.example.springkafkahelloworld.service.KafkaProducer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
public class KafkaController {

    private final KafkaProducer kafkaProducer;

    public KafkaController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @GetMapping("/")
    public void sign() {
        RandomClassObjectDto data = RandomClassObjectDto.builder()
                .documentIds(List.of(UUID.randomUUID(), UUID.randomUUID()))
                .organizationId("organizationId")
                .receiverEmail("receiver@email.com")
                .requestId(UUID.randomUUID().toString()).build();
        kafkaProducer.send(data);
    }

}
