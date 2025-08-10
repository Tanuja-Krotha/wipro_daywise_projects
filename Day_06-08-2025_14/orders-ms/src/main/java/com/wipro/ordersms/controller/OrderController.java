package com.wipro.ordersms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.ordersms.dto.Order;
import com.wipro.ordersms.dto1.OrderWithPaymentDTO;
import com.wipro.ordersms.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@PostMapping
	ResponseEntity<Order> save(@RequestBody Order order) {
		orderService.save(order);
        return ResponseEntity.ok(order);
	}
	
	@GetMapping("/all")
	public List<OrderWithPaymentDTO> getAllOrders() {
	    return orderService.findAll();
	}

}
