package com.wipro.paymentms.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "payment")
public class Payment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	
	@Column(name = "order_id")
	long orderId;

	@Column(name = "payment_mode")
	String paymentMode;
	
	@Column(name = "amount")
	Double amount;
	
	@Column(name = "description")
	String description;
	
	@Column(name = "payment_status")
	private boolean paymentStatus;

	
	public Payment()
	{
		super();
	}
	
	public Payment(int id, long orderId, String paymentMode, Double amount, String description, boolean paymentStatus) {
		super();
		this.id = id;
		this.orderId = orderId;
		this.paymentMode = paymentMode;
		this.amount = amount;
		this.description = description;
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

	public String getPaymentMode() {
		return paymentMode;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(boolean paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	@Override
	public String toString() {
		return "Payment [id=" + id + ", orderId=" + orderId + ", paymentMode=" + paymentMode + ", amount=" + amount
				+ ", description=" + description + ", paymentStatus=" + paymentStatus + "]";
	} 
	
	
	

}
