package com.wipro.consumer.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.wipro.consumer.model.Subject;
import com.wipro.consumer.service.ConsumerService;

@Component
public class ConsumerListener {
	@Autowired
    private ConsumerService consumerService;

    @KafkaListener(topics = "learn-subject", groupId = "my-group")
    public void listen(Subject subject) {
        consumerService.processSubject(subject);
    }

}
