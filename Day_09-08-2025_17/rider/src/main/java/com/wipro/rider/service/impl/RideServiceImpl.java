package com.wipro.rider.service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.wipro.rider.model.RideRequest;
import com.wipro.rider.repo.RideRepository;
import com.wipro.rider.service.RideService;

@Service
public class RideServiceImpl implements  RideService{

	@Autowired
	RideRepository rideRepository;
	
	@Autowired
	KafkaTemplate kafkaTemplate;
	
	private static final String Ride_Uber_TOPIC = "Ride_Uber";
	
	
	@Override
	public void createRide(RideRequest request)
	{ 
	        request.setStatus("PENDING");
	        rideRepository.save(request);
	        kafkaTemplate.send(Ride_Uber_TOPIC, request);
	        System.out.println("Sent to R2U: " + request);
	 }
		
	

}
