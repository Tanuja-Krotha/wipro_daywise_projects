package com.wipro.orderms.service;

import java.util.List;
import java.util.Optional;

import com.wipro.orderms.dto.Order;

public interface OrderServiceI {
	 
	Order placeOrder(Order order);
	
	List<Order> getAllOrders();
    
	Optional<Order> getOrderById(int id);
    
	Order updateOrder(int id, Order order);
    
	boolean deleteOrder(int id);
}
