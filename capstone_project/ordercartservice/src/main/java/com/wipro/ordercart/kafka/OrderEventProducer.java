package com.wipro.ordercart.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderEventProducer {
	 private final KafkaTemplate<String, String> kafkaTemplate;

	    public OrderEventProducer(KafkaTemplate<String, String> kafkaTemplate) {
	        this.kafkaTemplate = kafkaTemplate;
	    }

	    public void sendOrderCreated(int productId, int quantity) {
	        String message = "ORDER CREATED: productId=" + productId + ", qty=" + quantity;
	        kafkaTemplate.send("order-events", message);
	    }

	    public void sendOrderCancelled(int productId, int quantity) {
	        String message = "ORDER CANCELLED: productId=" + productId + ", qty=" + quantity;
	        kafkaTemplate.send("order-events", message);
	    }

}
