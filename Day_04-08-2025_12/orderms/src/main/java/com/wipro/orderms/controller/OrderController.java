package com.wipro.orderms.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.orderms.dto.Order;
import com.wipro.orderms.service.OrderServiceI;

@RestController
@RequestMapping("/orders")
public class OrderController {
	
	@Autowired
	OrderServiceI orderServiceI;
	
	
	 @PostMapping
	   public ResponseEntity<Order> placeOrder(@RequestBody Order order)
	 	{
	        Order savedOrder = orderServiceI.placeOrder(order);
	        return new ResponseEntity<>(savedOrder, HttpStatus.CREATED);
	    }
	
	 @GetMapping
	    public ResponseEntity<?> getAllOrders() {
	        List<Order> orders = orderServiceI.getAllOrders();

	        HttpHeaders headers = new HttpHeaders();
	        headers.add("search-time", LocalDateTime.now().toString());

	        if (orders.isEmpty()) 
	        {
	            return new ResponseEntity<>("No orders found", headers, HttpStatus.NOT_FOUND);
	        }

	        return new ResponseEntity<>(orders, headers, HttpStatus.OK);
	    }	
	 	
	 	@GetMapping("/{id}")
	    public ResponseEntity<?> getOrderById(@PathVariable int id) {
	        Optional<Order> order = orderServiceI.getOrderById(id);

	        HttpHeaders headers = new HttpHeaders();
	        headers.add("search-time", LocalDateTime.now().toString());

	        if (order.isEmpty()) {
	            return new ResponseEntity<>("Order not found", headers, HttpStatus.NOT_FOUND);
	        }

	        return new ResponseEntity<>(order.get(), headers, HttpStatus.OK);
	    }

	 @PutMapping("/{id}")
	    public ResponseEntity<String> updateOrder(@PathVariable int id, @RequestBody Order updatedOrder) {
	        Order updated = orderServiceI.updateOrder(id, updatedOrder);
	        if (updated != null) {
	            return new ResponseEntity<>("Order updated successfully", HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>("Order not found", HttpStatus.NOT_FOUND);
	        }
	    }
	 	
	 	@DeleteMapping("/{id}")
	    public ResponseEntity<String> deleteOrder(@PathVariable int id) {
	        boolean deleted = orderServiceI.deleteOrder(id);
	        if (deleted) {
	            return new ResponseEntity<>("Order deleted successfully", HttpStatus.OK);
	        } else 
	        {
	            return new ResponseEntity<>("Order not found", HttpStatus.NOT_FOUND);
	        }
	 }
	 	
}
