package com.wipro.logdemo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogController {
	
	private static final Logger logger = LoggerFactory.getLogger(LogController.class);
	@GetMapping("/greet")
	String greet()
	{
		String str = "Tanuja";
		System.out.println("--LOG CONTROLLER--");
		logger.error("--Error--");
		logger.warn("--WARN--");
		logger.info("--INFO--");
		logger.debug("--DEBUG--");
		logger.trace("-TRACE--");
		return "Greetings from Spring Boot!";
	}
}

