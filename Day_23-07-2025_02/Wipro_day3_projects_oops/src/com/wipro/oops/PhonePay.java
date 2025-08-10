package com.wipro.oops;

public class PhonePay implements PaymentMethod {

	@Override
	public void pay(double amount) {
		System.out.println("Paid ₹" + amount + " using PhonePay.");
		
	}

}
