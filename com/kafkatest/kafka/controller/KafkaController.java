package com.kafkatest.kafka.controller;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class KafkaController {

    private KafkaTemplate<String, String> template;

    public KafkaController(KafkaTemplate<String, String> template) {
        this.template = template;
    }

    @GetMapping("/kafka/produce")
    public void produce(@RequestParam String message) {
        template.send("KafkaTest", message );
    }

    @GetMapping("/kafka/produce-full")
    public void produce(@RequestParam String message, @RequestParam String topic) {
        template.send(topic, message);
    }    
    
}
