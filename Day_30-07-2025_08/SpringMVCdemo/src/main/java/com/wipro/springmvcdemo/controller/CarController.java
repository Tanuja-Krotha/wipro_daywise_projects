package com.wipro.springmvcdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wipro.springmvcdemo.service.CarServiceI;

@Controller
@RequestMapping("/car")
public class CarController 
{
	@Autowired
	CarServiceI carservicei;
	
	@GetMapping("/list")
	String showProdList(Model model)
	{ 
		model.addAttribute("carList", carservicei.getCarList());
		return "carlist";
		
	}
	
}
