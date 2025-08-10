package com.wipro.orderms.entity;

public class Payment {
	int id;
	long orderId;
	double amount;
	boolean paymentStatus;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public long getOrderId() 
	{ 
		return orderId; 
		}
    public void setOrderId(long orderId) { this.orderId = orderId; }
	public Double getAmount() {
		return amount;
	}
	public void setAmount(double string) {
		this.amount = string;
	}
	public boolean isPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(boolean paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
}
