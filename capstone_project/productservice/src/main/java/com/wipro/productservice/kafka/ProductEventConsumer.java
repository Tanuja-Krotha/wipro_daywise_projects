package com.wipro.productservice.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

import com.wipro.productservice.service.ProductService;

public class ProductEventConsumer {
	@Autowired
	ProductService productService;
	
	@KafkaListener(topics = "order-events", groupId = "product-service-group")
	public void consume(String message) {
		String[] parts = message.split(":");
		String type = parts[0];
		Long productId = (long) Integer.parseInt(parts[1]);
		int quantity = Integer.parseInt(parts[2]);
		
		if("ORDER_CREATED".equals(type)) {
			productService.decreaseStock(productId, quantity);
		} else if("ORDER_CANCELLED".equals(type)) {
			productService.increaseStock(productId, quantity);
		}
	}

}
