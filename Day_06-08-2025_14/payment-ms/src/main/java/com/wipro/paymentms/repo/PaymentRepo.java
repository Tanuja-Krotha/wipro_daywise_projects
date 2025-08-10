package com.wipro.paymentms.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.paymentms.dto.Payment;

@Repository
public interface PaymentRepo extends JpaRepository<Payment, Long> {
	List<Payment> findByOrderId(Long orderId);

}
