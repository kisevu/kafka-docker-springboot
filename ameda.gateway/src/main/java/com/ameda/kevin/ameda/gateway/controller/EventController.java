package com.ameda.kevin.ameda.gateway.controller;

import com.ameda.kevin.ameda.gateway.model.TransactionMessage;
import com.ameda.kevin.ameda.gateway.service.KafkaProducerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/gateway")
@Slf4j
public class EventController {
    private final KafkaProducerService kafkaProducerService;
    @PostMapping("/event")
    public ResponseEntity<String> event(@RequestBody TransactionMessage transactionMessage){
        UUID uuid = UUID.randomUUID();
        kafkaProducerService
                .send("transaction-topic", uuid,transactionMessage);
        log.info("We received the transaction with the key"+ uuid);
        return ResponseEntity.ok("sent");
    }
}
