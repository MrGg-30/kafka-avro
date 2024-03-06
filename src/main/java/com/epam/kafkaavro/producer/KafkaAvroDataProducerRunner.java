package com.epam.kafkaavro.producer;

import com.avro.schema.StockHistory;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class KafkaAvroDataProducerRunner implements CommandLineRunner {

    private final KafkaAvroProducer kafkaAvroProducer;

    @Override
    public void run(String... args) throws Exception {
        StockHistory sampleStockHistory = createSampleStockHistory();
        kafkaAvroProducer.send(sampleStockHistory);
    }

    private StockHistory createSampleStockHistory() {
        StockHistory stockHistory = new StockHistory();
        stockHistory.setStockName("stock");
        stockHistory.setTradeId(1);
        stockHistory.setTradeMarket("big-market");
        stockHistory.setTradeType("b2b");
        return stockHistory;
    }
}
