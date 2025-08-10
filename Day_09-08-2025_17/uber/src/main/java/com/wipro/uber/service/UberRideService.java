package com.wipro.uber.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.wipro.uber.dto.RideRequest;

@Service
public class UberRideService {
	
	private static final String Uber_Ride_TOPIC = "Uber_Ride";

    @Autowired
    private KafkaTemplate<String, RideRequest> kafkaTemplate;

    @KafkaListener(topics = "Uber_Ride", groupId = "uber-service")
    public void processRideRequest(RideRequest request) {
        System.out.println("Uber Service received booking: " + request);
        request.setStatus("CONFIRMED");
        kafkaTemplate.send(Uber_Ride_TOPIC, request);
        System.out.println("Uber Service sent status update: " + request);
    }

}
