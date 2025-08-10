package com.wipro.orderms.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="order")
public class Order {
	
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int id;
	 	@Column(name="order_number")
	    private String orderNumber;
	 	@Column(name="order_value")
	 	private double orderValue;
	 	@Column(name="order_status")
	 	private String orderStatus;
	 	
	 	public Order()
	 	{
	 		super();
	 	}

		public Order(int id, String orderNumber, double orderValue, String orderStatus) {
			super();
			this.id = id;
			this.orderNumber = orderNumber;
			this.orderValue = orderValue;
			this.orderStatus = orderStatus;
		}

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
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

		public String getOrderStatus() {
			return orderStatus;
		}

		public void setOrderStatus(String orderStatus) {
			this.orderStatus = orderStatus;
		}

		@Override
		public String toString() {
			return "Order [id=" + id + ", orderNumber=" + orderNumber + ", orderValue=" + orderValue + ", orderStatus="
					+ orderStatus + "]";
		}
	 	
	 	
}
