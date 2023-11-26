package com.ameda.kevin.consumer.services;

import com.ameda.kevin.consumer.model.TransactionMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class KafkaConsumerService {

    @KafkaListener(topics = {"transaction-topic"},groupId = "group-id")
    public void consume(TransactionMessage transactionMessage){
        log.info("we received the transaction with the id"
                + transactionMessage.getTransactionId() +
                " The status is: "+ transactionMessage.getStatus()
        );
    }
}

