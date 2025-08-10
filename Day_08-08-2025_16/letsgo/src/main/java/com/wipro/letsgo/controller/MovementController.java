package com.wipro.letsgo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.letsgo.dto.VehicleMovement;
import com.wipro.letsgo.service.MovementService;

@RestController
@RequestMapping("/movement")
public class MovementController {
	
	@Autowired
    private MovementService service;

    @PostMapping()
    public String moveVehicle(@RequestBody VehicleMovement movement) {
        service.saveMovement(movement);
        return "Movement saved successfully";
    }

    @GetMapping()
    public List<VehicleMovement> getAllMovements() {
        return service.getAllMovements();
    }

}
