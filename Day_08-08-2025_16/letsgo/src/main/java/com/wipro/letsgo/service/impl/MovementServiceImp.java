package com.wipro.letsgo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.letsgo.dto.VehicleMovement;
import com.wipro.letsgo.repo.VehicleMovementRepository;
import com.wipro.letsgo.service.MovementService;

@Service
public class MovementServiceImp implements MovementService {
	
	 
		@Autowired
	    private VehicleMovementRepository repo;

	    @Override
	    public VehicleMovement saveMovement(VehicleMovement movement) {
	        return repo.save(movement);
	    }

	    @Override
	    public List<VehicleMovement> getAllMovements() {
	        return repo.findAll();
	    }

}
