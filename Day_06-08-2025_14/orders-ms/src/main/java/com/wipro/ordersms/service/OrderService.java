package com.wipro.ordersms.service;

import java.util.List;

import com.wipro.ordersms.dto.Order;
import com.wipro.ordersms.dto1.OrderWithPaymentDTO;

public interface OrderService {
	
	void save(Order order);
	
	List<OrderWithPaymentDTO> findAll();

}
