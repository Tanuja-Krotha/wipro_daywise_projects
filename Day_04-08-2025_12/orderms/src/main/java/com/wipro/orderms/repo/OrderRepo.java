package com.wipro.orderms.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.orderms.dto.Order;

@Repository
public interface OrderRepo extends JpaRepository<Order, Integer>{

}
