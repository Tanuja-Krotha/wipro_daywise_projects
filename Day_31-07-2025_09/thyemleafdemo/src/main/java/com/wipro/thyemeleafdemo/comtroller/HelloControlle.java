package com.wipro.thyemeleafdemo.comtroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloControlle {
	 @GetMapping("/welcome")
	    public String showWelcome(Model model) {
	        model.addAttribute("name", "Tanuja Krotha");
	        model.addAttribute("message", "Welcome to Spring MVC with Thymeleaf!");
	        return "index"; 
	    }

}
