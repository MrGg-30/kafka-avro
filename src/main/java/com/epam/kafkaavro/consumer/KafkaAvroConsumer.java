package com.epam.kafkaavro.consumer;

import com.avro.schema.StockHistory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaAvroConsumer {

    private final String topic = "test";

    @KafkaListener(topics = topic, groupId = "id")
    public void consume(StockHistory stockHistory) {
        System.out.println("Received message from Kafka: " + stockHistory.toString());
    }
}
