package com.ameda.kevin.ameda.gateway.config;


import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaConfig {
    @Bean
    public NewTopic transactionTopic(){
        return TopicBuilder.name("transaction-topic")
                .partitions(1)
                .replicas(1)
                .build();
    }

//    @Bean
//    public KafkaAdmin.NewTopics topicsMultiple(){
//        return new KafkaAdmin.NewTopics(
//                TopicBuilder.name("withdraw-broker")
//                        .build(),
//                TopicBuilder.name("deposit-broker")
//                        .replicas(1)
//                        .build(),
//                TopicBuilder.name("fraud-broker")
//                        .partitions(1).build()
//        );
//    }
}
