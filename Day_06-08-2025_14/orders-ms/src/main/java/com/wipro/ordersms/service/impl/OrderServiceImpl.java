package com.wipro.ordersms.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.wipro.ordersms.dto.Order;
import com.wipro.ordersms.dto1.OrderWithPaymentDTO;
import com.wipro.ordersms.dto1.Payment;
import com.wipro.ordersms.repo.OrderRepo;
import com.wipro.ordersms.service.OrderService;
import com.wipro.ordersms.service.PaymentConnectService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class OrderServiceImpl implements OrderService{
	
	@Autowired
	OrderRepo orderRepo;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Autowired
	PaymentConnectService paymentConnectService;

	@Override
	@CircuitBreaker(name = "order-cb", fallbackMethod = "handleFallBack")
	public void save(Order order) {
		order.setOrderStatus("I");
		Order saveOrder = orderRepo.save(order);
		
		Payment payment = new Payment();
		payment.setOrderId(order.getId());
		payment.setAmount(order.getOrderValue());
		payment.setPaymentStatus(false);
		
			String url = "http://payment-ms/payment"; 
			ResponseEntity<Payment> savedPayment = paymentConnectService.savePaymentData(payment);

	        if (savedPayment.getStatusCode().is2xxSuccessful()) 
	        {
	            saveOrder.setOrderStatus("P"); 
	        } 
		
		orderRepo.save(saveOrder);

	}

	@Override
	@CircuitBreaker(name = "order-cb", fallbackMethod = "handleFallBack")
	public List<OrderWithPaymentDTO> findAll() {
		
		List<Order> orders = orderRepo.findAll();

	    return orders.stream().map(order -> {
	        OrderWithPaymentDTO dto = new OrderWithPaymentDTO();
	        dto.setOrderNumber(order.getOrderNumber());
	        dto.setOrderValue(order.getOrderValue());
	        	
		        List<Payment> payments = paymentConnectService.getPaymentsByOrderId(order.getId());
	            dto.setPayment(payments != null ? payments : List.of());
	        return dto;
	    }).collect(Collectors.toList());
	}
	

	
	
	public void handleFallBack(Order order, Throwable t) {
	    System.out.println("---System is down. Could not save order---");
	    
	}

	
	public List<OrderWithPaymentDTO> handleFallBack(Throwable t) {
	    System.out.println("---System is down. Returning empty order list---");
	    return Collections.emptyList();
	}

}
