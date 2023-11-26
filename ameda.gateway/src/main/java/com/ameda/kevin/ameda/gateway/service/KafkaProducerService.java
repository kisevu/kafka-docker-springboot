package com.ameda.kevin.ameda.gateway.service;

import com.ameda.kevin.ameda.gateway.model.TransactionMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaProducerService {
    private final KafkaTemplate<UUID, TransactionMessage> kafkaTemplate;
    public void send(String topicName,UUID key, TransactionMessage transactionMessage){
        var future = kafkaTemplate.send(topicName,key,transactionMessage);
        future.whenComplete((sendResult,exception)->{
            if(exception!=null){
                log.error(exception.getMessage());
                future.completeExceptionally(exception);
            }else{
                future.complete(sendResult);
            }
            log.
                    info("The id is: "+ transactionMessage.getTransactionId()+"transaction status to kafka topic: "+transactionMessage.getStatus());
        });
    }
}
