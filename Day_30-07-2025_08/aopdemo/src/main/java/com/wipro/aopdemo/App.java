package com.wipro.aopdemo;
 
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
 
import com.wipro.aopdemo.configuration.AirTravelConfiguration;
import com.wipro.aopdemo.service.AirTravelProcess;
 
/**
* Hello world!
*
*/
public class App {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.scan("com.wipro.aopdemo.*");
		ctx.refresh();
		AirTravelProcess travel = ctx.getBean(AirTravelProcess.class);
 
		try {
			travel.checkIn(true);
			travel.collectBoardingPass();
            travel.doSecurityCheck();
			travel.doSecurityCheck();
			travel.doBoarding();
		} 
		catch (Exception ex)
		{
			System.out.println("Contact AirLane Management");
		}
 
	}
}