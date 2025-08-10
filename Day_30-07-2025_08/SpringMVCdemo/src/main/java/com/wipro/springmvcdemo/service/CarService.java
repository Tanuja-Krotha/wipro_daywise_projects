package com.wipro.springmvcdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.springmvcdemo.repo.CarRepo;
@Service
public class CarService implements CarServiceI{
	@Autowired
	CarRepo carRepo;
	
	
	@Override
	public List<String> getCarList() {
		
		return carRepo.getCarList();
	}

}
