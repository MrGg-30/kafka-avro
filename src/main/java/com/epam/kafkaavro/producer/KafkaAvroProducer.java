package com.epam.kafkaavro.producer;

import com.avro.schema.StockHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.kafka.support.SendResult;
import java.util.concurrent.CompletableFuture;

@Service
public class KafkaAvroProducer {

    @Autowired
    private KafkaTemplate<String, StockHistory> kafkaTemplate;

    public void send(StockHistory stockHistory) {
        CompletableFuture<SendResult<String, StockHistory>> send = kafkaTemplate.send("test", String.valueOf(stockHistory.getTradeId()), stockHistory);
        send.whenComplete((sendResult, throwable) -> {
            if (throwable == null) {
                System.out.println("Message sent successfully to Kafka topic: " + sendResult.getRecordMetadata().topic());
            } else {
                System.err.println("Error sending message to Kafka: " + throwable.getMessage());
                throwable.printStackTrace();
            }
        });
        send.whenComplete((sendResult, throwable) -> {
            System.out.println("Message send operation completed.");
        });
    }
}