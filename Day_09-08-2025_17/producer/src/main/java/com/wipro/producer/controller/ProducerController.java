package com.wipro.producer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.producer.model.Subject;
import com.wipro.producer.service.ProducerService;

@RestController
@RequestMapping("/produce")
public class ProducerController {
	
	@Autowired
	ProducerService producerService;
	
	@PostMapping
    public void sendSubject(@RequestBody Subject subject) {
		producerService.sendSubject(subject);
    }

}
