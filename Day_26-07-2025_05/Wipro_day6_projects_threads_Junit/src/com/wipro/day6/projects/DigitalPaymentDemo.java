package com.wipro.day6.projects;

interface PaymentApp 
{
	void makePayment(double amount);
}


class GooglePay implements PaymentApp 
{
	public void makePayment(double amount) 
		{
			System.out.println("Paid ₹" + amount + " using GooglePay");
		}
}

class PhonePe implements PaymentApp {
 public void makePayment(double amount) {
     System.out.println("Paid ₹" + amount + " using PhonePe");
 }
}


class Paytm implements PaymentApp 
	{
		public void makePayment(double amount) 
		{
			System.out.println("Paid ₹" + amount + " using Paytm");
		}
}


class PaymentService 
{
	private PaymentApp paymentApp;

	public PaymentService(PaymentApp paymentApp) 
	{
		this.paymentApp = paymentApp;
	}

 public void processPayment(double amount) 
 {
     paymentApp.makePayment(amount);
 }

}


public class DigitalPaymentDemo 
{
	public static void main(String[] args) 
	{
     
	     PaymentApp gpay = new GooglePay();
	     PaymentApp phonepe = new PhonePe();
	     PaymentApp paytm = new Paytm();
	
	     PaymentService service1 = new PaymentService(gpay);
	     PaymentService service2 = new PaymentService(phonepe);
	     PaymentService service3 = new PaymentService(paytm);
	
	     service1.processPayment(1000.00);
	     service2.processPayment(500.50);
	     service3.processPayment(250.75);
	}
}

