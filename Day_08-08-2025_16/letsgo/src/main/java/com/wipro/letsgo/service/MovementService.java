package com.wipro.letsgo.service;

import java.util.List;

import com.wipro.letsgo.dto.VehicleMovement;

public interface MovementService {
	
	VehicleMovement saveMovement(VehicleMovement movement);
    
	List<VehicleMovement> getAllMovements();

}
