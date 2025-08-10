package com.wipro.ordersms.dto1;

public class Payment {
	
	int id;
	long orderId;
	double amount;
	boolean paymentStatus;
	
	public Payment()
	{
		super();
	}
	
	
	
	public Payment(int id, long orderId, double amount, boolean paymentStatus) {
		super();
		this.id = id;
		this.orderId = orderId;
		this.amount = amount;
		this.paymentStatus = paymentStatus;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public boolean isPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(boolean paymentStatus) {
		this.paymentStatus = paymentStatus;
	}



	@Override
	public String toString() {
		return "Payment [id=" + id + ", orderId=" + orderId + ", amount=" + amount + ", paymentStatus=" + paymentStatus
				+ "]";
	}
	
	

}
