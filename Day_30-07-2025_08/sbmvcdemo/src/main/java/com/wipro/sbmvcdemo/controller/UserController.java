package com.wipro.sbmvcdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wipro.sbmvcdemo.moedel.User;
import com.wipro.sbmvcdemo.service.UserServiceI;

@Controller
@RequestMapping("/city")
public class UserController
{
	
	UserServiceI userServiceI;
	
	 @GetMapping("/userform")
    public String showForm(Model model)
	 {
        model.addAttribute("user", new User());
        return "userreg"; 
	 }
	 @PostMapping("/register")
	    public String submitForm(@ModelAttribute("user") User user) 
	 {
	        userServiceI.registerUser(user); 
	        return "success";
	 }
}
