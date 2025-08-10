package com.wipro.payment.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.payment.dto.Payment;

@Repository
public interface PaymentRepo extends JpaRepository<Payment,Integer> {

}
