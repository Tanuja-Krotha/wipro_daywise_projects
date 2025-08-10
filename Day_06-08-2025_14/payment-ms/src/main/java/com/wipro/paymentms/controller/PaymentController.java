package com.wipro.paymentms.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.paymentms.dto.Payment;
import com.wipro.paymentms.repo.PaymentRepo;
import com.wipro.paymentms.service.PaymentService;

@RestController
@RequestMapping("/payment")
public class PaymentController {
	
	@Autowired
	PaymentService paymentService;
	
	@Autowired
	PaymentRepo paymentRepo;
	
	@PostMapping
	ResponseEntity<Payment> save(@RequestBody Payment payment) {
		payment.setPaymentMode("UPI"); // default mode
	    payment.setDescription("Auto payment entry");
	    payment.setPaymentStatus(true);
		
		Payment savedPayment = paymentService.save(payment);
		
	    if (savedPayment.isPaymentStatus()) {
	    		return ResponseEntity.ok(savedPayment);
	    }

	    return ResponseEntity.ok(savedPayment);
	}
	
	@GetMapping
	ResponseEntity<List<Payment>> findAll() {
		List<Payment> payments = paymentService.findAll();
		
		HttpHeaders headers= new HttpHeaders();
		headers.add("Serah-time", LocalDateTime.now().toString());
		
		if(payments.isEmpty()) {
			return ResponseEntity.status(404).headers(headers).build();
		} 
		
		return ResponseEntity.ok().headers(headers).body(payments);
	}
	
	@GetMapping("/{id}")
	ResponseEntity<Payment> findById(@PathVariable Long id) {
		Payment payment = paymentService.findById(id);
		
		HttpHeaders headers= new HttpHeaders();
		headers.add("Serah-time", LocalDateTime.now().toString());
		
		if(payment == null) {
			return ResponseEntity.status(404).headers(headers).build();
		} 
		
		return ResponseEntity.ok().headers(headers).body(payment);
	}
	
	@DeleteMapping("/{id}")
	ResponseEntity<String> deleteById(@PathVariable Long id) {
		
		paymentService.deleteById(id);
		
		return ResponseEntity
				.status(200)
				.body("Data deleted Successfully");
	}
	
	@PutMapping("/{id}")
	ResponseEntity<String> updateById(@PathVariable Long id,@RequestBody Payment payment) {
		
		paymentService.updateById(id, payment);
		
		return ResponseEntity
				.status(200)
				.body("Data modified Successfully");
	}
	
	 @GetMapping("/order/{orderId}")
	    public List<Payment> getPaymentsByOrderId(@PathVariable Long orderId) {
	        return paymentRepo.findByOrderId(orderId);
	    }

}
