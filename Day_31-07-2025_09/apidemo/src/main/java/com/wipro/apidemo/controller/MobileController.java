package com.wipro.apidemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.apidemo.model.Mobile;
import com.wipro.apidemo.service.MobileServiceI;

@RestController
public class MobileController {
	
	 /*@GetMapping("/weather")
	    public String getWeather(@RequestParam String city, @RequestParam String day) 
	 	{
	        return "Weather in " + city + " for " + day + " is rainy.";
	 	}
	
	 @GetMapping("/tocentigrade/{fahrenheit}")
	 public String convertToCelsius(@PathVariable double fahrenheit) {
	     double celsius = (fahrenheit - 32) * 5 / 9;
	     return fahrenheit + "°F in Celsius is " + String.format("%.1f", celsius) + "°C";
	 }*/

	 @Autowired
	 public MobileServiceI mobileService;
	
	
	
	
	@PostMapping("/mobile")
	public Mobile addMobile(@RequestBody Mobile mobile)
	{
		return mobileService.addMobile(mobile);
	}
	
	@GetMapping("/mobile")
	public List<Mobile> getAllMobile()
	{
		return mobileService.getAllMobiles();
	}
	
	@PutMapping("mobile/{id}")
    public Mobile updateMobile(@RequestBody Mobile mobile, @PathVariable int id) 
	{
        return mobileService.updateMobile(mobile, id);
    }
	
	@GetMapping("mobile/{id}")
	public Mobile getMobileById(@PathVariable int id) 
	 	{
	        return mobileService.getMobileById(id);
	    }
	
	@DeleteMapping("mobile/{id}")
    public String deleteMobile(@PathVariable int id)
	{
        return mobileService.deleteMobile(id);
    }
	
}
