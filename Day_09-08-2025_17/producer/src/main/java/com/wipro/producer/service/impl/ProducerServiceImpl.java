package com.wipro.producer.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.wipro.producer.model.Subject;
import com.wipro.producer.service.ProducerService;

@Service
public class ProducerServiceImpl implements ProducerService {
	private static final String TOPIC = "learn-subject";

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    @Override
    public void sendSubject(Subject subject) {
       kafkaTemplate.send(TOPIC, subject);
       System.out.println("Sent to topic '" + TOPIC + "': " + subject);
    }

}
