package com.wipro.payment.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="payment")
public class Payment 
{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int paymentId;
	@Column(name="payment_mode")
    private String paymentMode;
	@Column(name="amount")
	private double amount;
	@Column(name="payment_description")
	private String paymentDescription;
	@Column(name="order_id")
	private int orderId;
	@Column(name="payment_status")
	private boolean paymentStatus;
	
	public Payment()
	{
		super();
	}

	public Payment(int paymentId, String paymentMode, double amount, String paymentDescription,int orderId,boolean paymentStatus ) {
		super();
		this.paymentId = paymentId;
		this.paymentMode = paymentMode;
		this.amount = amount;
		this.paymentDescription = paymentDescription;
		this.orderId= orderId;
		this.paymentStatus=paymentStatus;
	}

	public int getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getPaymentDescription() {
		return paymentDescription;
	}

	public void setPaymentDescription(String paymentDescription) {
		this.paymentDescription = paymentDescription;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public boolean isPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(boolean paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", paymentMode=" + paymentMode + ", amount=" + amount
				+ ", paymentDescription=" + paymentDescription + ", orderId=" + orderId + ", paymentStatus="
				+ paymentStatus + "]";
	}

	
	
}
