package com.wipro.paymentms.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.paymentms.dto.Payment;
import com.wipro.paymentms.repo.PaymentRepo;
import com.wipro.paymentms.service.PaymentService;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	PaymentRepo paymentRepo;

	@Override
	public Payment save(Payment payment) {
		return paymentRepo.save(payment);
	}

	@Override
	public List<Payment> findAll() {	
		return paymentRepo.findAll();
	}

	@Override
	public Payment findById(Long id) {
		return paymentRepo.findById(id).orElse(null);
	}

	@Override
	public void deleteById(Long id) {
		paymentRepo.deleteById(id);
	}

	@Override
	public Payment updateById(Long id, Payment payment) {
		return paymentRepo.findById(id)
        .map(p -> {
        		p.setOrderId(payment.getOrderId());
            p.setPaymentMode(payment.getPaymentMode());
            p.setAmount(payment.getAmount());
            p.setDescription(payment.getDescription());
            p.setPaymentStatus(payment.isPaymentStatus());
            return paymentRepo.save(p); 
        })
		.orElse(null);
	}
}
