package com.wipro.oops;

public class GPay implements PaymentMethod {

	@Override
	public void pay(double amount) {
		System.out.println("Paid ₹" + amount + " using Gpay.");
		
	}

}
