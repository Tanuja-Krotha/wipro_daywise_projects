package com.wipro.payment.service;

import java.util.List;
import java.util.Optional;

import com.wipro.payment.dto.Payment;

public interface PaymentServiceI {
	public Payment createPayment(Payment payment);
    
	public List<Payment> getAllPayments();
    
	public Optional<Payment> getPaymentById(int id);
    
	public Payment updatePayment(int id, Payment payment);
    
	public void deletePayment(int id);

}
