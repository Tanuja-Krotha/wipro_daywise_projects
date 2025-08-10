package com.wipro.ordersms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


//@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication(scanBasePackages = "com.wipro.ordersms")
public class OrdersMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrdersMsApplication.class, args);
	}

}
