package com.wipro.payment.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.payment.dto.Payment;
import com.wipro.payment.service.PaymentServiceI;

@RestController
@RequestMapping("/payments")
public class PaymentController {
	
	@Autowired
	PaymentServiceI paymentServiceI;
	
	@PostMapping
    public ResponseEntity<Payment>  create(@RequestBody Payment payment) {
		Payment created = paymentServiceI.createPayment(payment);
		return ResponseEntity.ok(created);
	}

    @GetMapping
    public ResponseEntity<?> getAll() {
    	List<Payment> payments = paymentServiceI.getAllPayments();

        HttpHeaders headers = new HttpHeaders();
        headers.add("search-time", LocalDateTime.now().toString());

        if (payments.isEmpty()) 
        {
            return new ResponseEntity<>("No payments found", headers, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(payments, headers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable int id) {
    	Optional<Payment> payment = paymentServiceI.getPaymentById(id);

        HttpHeaders headers = new HttpHeaders();
        headers.add("search-time", LocalDateTime.now().toString());

        if (payment.isEmpty()) 
        {
            return new ResponseEntity<>("Payment not found", headers, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(payment.get(), headers, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public Payment update(@PathVariable int id, @RequestBody Payment payment) {
        return paymentServiceI.updatePayment(id, payment);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
    	paymentServiceI.deletePayment(id);
    }
	
	

}
