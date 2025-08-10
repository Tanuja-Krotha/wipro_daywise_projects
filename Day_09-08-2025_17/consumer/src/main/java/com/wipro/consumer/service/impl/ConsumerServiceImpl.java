package com.wipro.consumer.service.impl;

import org.springframework.stereotype.Service;

import com.wipro.consumer.model.Subject;
import com.wipro.consumer.service.ConsumerService;

@Service
public class ConsumerServiceImpl implements ConsumerService {
	 
		@Override
	    public void processSubject(Subject subject) {
	        System.out.println("Consumed Subject: " + subject);
	    }

}
