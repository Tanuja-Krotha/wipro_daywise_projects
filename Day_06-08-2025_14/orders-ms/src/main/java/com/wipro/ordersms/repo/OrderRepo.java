package com.wipro.ordersms.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.ordersms.dto.Order;

@Repository
public interface OrderRepo extends JpaRepository<Order, Integer> {

}
