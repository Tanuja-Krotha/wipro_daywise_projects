package com.wipro.ordersms.dto1;

import java.util.List;

public class OrderWithPaymentDTO {
	
	String orderNumber;
    double orderValue;
    List<Payment> payment;
    
    public OrderWithPaymentDTO()
    {
    	super();
    }

	public OrderWithPaymentDTO(String orderNumber, double orderValue, List<Payment> payment) {
		super();
		this.orderNumber = orderNumber;
		this.orderValue = orderValue;
		this.payment = payment;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public double getOrderValue() {
		return orderValue;
	}

	public void setOrderValue(double orderValue) {
		this.orderValue = orderValue;
	}

	public List<Payment> getPayment() {
		return payment;
	}

	public void setPayment(List<Payment> payment) {
		this.payment = payment;
	}

	@Override
	public String toString() {
		return "OrderWithPaymentDTO [orderNumber=" + orderNumber + ", orderValue=" + orderValue + ", payment=" + payment
				+ "]";
	}
    

}
