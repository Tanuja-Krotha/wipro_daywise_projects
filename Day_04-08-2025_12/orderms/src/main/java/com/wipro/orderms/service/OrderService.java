package com.wipro.orderms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.wipro.orderms.dto.Order;
import com.wipro.orderms.entity.Payment;
import com.wipro.orderms.repo.OrderRepo;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class OrderService implements OrderServiceI {
	
	@Autowired
	OrderRepo orderRepo;
	 @Autowired
	 RestTemplate restTemplate;
	 @Autowired
	 PaymentConnectService paymentConnectService;
	
	@Override
	@CircuitBreaker(name="order-cb" , fallbackMethod="handleFallBack")
	public Order placeOrder(Order order) 
	{
		order.setOrderStatus("I"); 
        Order savedOrder = orderRepo.save(order);
        String url="http://payment/payment";
        Payment payment=new Payment();
        payment.setOrderId(order.getId());
		payment.setAmount(order.getOrderValue());
		payment.setPaymentStatus(true);
        

        try {
        	ResponseEntity<Payment>   response= paymentConnectService.savePaymentData(payment);

            if (response.getStatusCode() == HttpStatus.OK) 
            {
                savedOrder.setOrderStatus("P"); 
            } 
            else 
            {
                savedOrder.setOrderStatus("C"); 
            }

        } 
        catch (Exception e) 
        {
            savedOrder.setOrderStatus("C"); 
        }

        return orderRepo.save(savedOrder);
    }

	@Override
    public List<Order> getAllOrders() {
        return orderRepo.findAll();
    }

    @Override
    public Optional<Order> getOrderById(int id) {
        return orderRepo.findById(id);
    }

    @Override
    public Order updateOrder(int id, Order updatedOrder) {
        Optional<Order> existingOrder = orderRepo.findById(id);
        if (existingOrder.isPresent()) {
            Order order = existingOrder.get();
            order.setOrderNumber(updatedOrder.getOrderNumber());
            order.setOrderValue(updatedOrder.getOrderValue());
            order.setOrderStatus(updatedOrder.getOrderStatus());
            return orderRepo.save(order);
        }
        return null;
    }

    @Override
    public boolean deleteOrder(int id) {
        Optional<Order> existingOrder = orderRepo.findById(id);
        if (existingOrder.isPresent()) {
        	orderRepo.deleteById(id);
            return true;
        }
        return false;
    }
    String handleFallBack(Throwable t)
	{
		
		System.out.println("--System is down--");
		return "System is down";
	}

}
