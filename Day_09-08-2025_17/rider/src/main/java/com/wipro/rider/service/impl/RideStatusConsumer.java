package com.wipro.rider.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.wipro.rider.model.RideRequest;
import com.wipro.rider.repo.RideRepository;

@Component
public class RideStatusConsumer {
	
	@Autowired
    private RideRepository rideRepository;

    @KafkaListener(topics = "Uber_Ride", groupId = "rider-service")
    public void consumeRideStatus(RideRequest rideUpdate) {
        RideRequest ride = rideRepository.findById(rideUpdate.getRideId()).get();
        if (ride != null) {
            ride.setStatus(rideUpdate.getStatus());
            rideRepository.save(ride);
            System.out.println("Updated ride status: " + ride);
        }
    }

}
