package com.ameda.kevin.consumer.model;

import lombok.*;
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class TransactionMessage {
    //How our message will be structured...
    private Long transactionId;
    private Event event;
    private Double amount;
    private Status status;
    public enum Event{
        DEPOSIT,WITHDRAW
    }
    public enum Status{
        SUBMITTED,STARTED, PENDING, FINISHED, TERMINATED
    }
}

