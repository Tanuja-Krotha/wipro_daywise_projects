package com.wipro.payment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.payment.dto.Payment;
import com.wipro.payment.repo.PaymentRepo;

@Service
public class PaymentService implements PaymentServiceI {

	@Autowired
	PaymentRepo paymentRepo;
	
	@Override
	public Payment createPayment(Payment payment) {
		return paymentRepo.save(payment);
	}

	@Override
	public List<Payment> getAllPayments() {
		return paymentRepo.findAll();
	}

	@Override
	public Optional<Payment> getPaymentById(int id) {
		return paymentRepo.findById(id);
	}

	@Override
	public Payment updatePayment(int id, Payment payment) {
		Payment existing = paymentRepo.findById(id).orElseThrow();
        existing.setAmount(payment.getAmount());
        existing.setPaymentMode(payment.getPaymentMode());
        existing.setPaymentDescription(payment.getPaymentDescription());
        return paymentRepo.save(existing);
	}

	@Override
	public void deletePayment(int id) {
		paymentRepo.deleteById(id);
		
	}

}
