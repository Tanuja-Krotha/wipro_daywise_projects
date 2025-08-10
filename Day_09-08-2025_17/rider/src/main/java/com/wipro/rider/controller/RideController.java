package com.wipro.rider.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.rider.model.RideRequest;
import com.wipro.rider.service.RideService;

@RestController
@RequestMapping("/ride")
public class RideController {
	
	 	@Autowired
	    private RideService rideService;

	    @PostMapping
	    public String requestRide(@RequestBody RideRequest request) 
	    {
	        rideService.createRide(request);
	        return "Ride request submitted with ID: " + request.getRideId();
	    }

}
