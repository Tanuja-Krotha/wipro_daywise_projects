package com.wipro.ordercartservice.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "order")
public class Order {
	
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    
	    @Column(name = "user_id", nullable = false)
	    private Long userId;
	    
	    @Column(name = "order_date", nullable = false)
	    private LocalDateTime orderDate;
	    
	    @Enumerated(EnumType.STRING)
	    @Column(nullable = false)
	    private OrderStatus status;
	    
	    @Column(nullable = false)
	    private Double totalAmount;
	    
	    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	    private List<OrderItem> items;
	    
	    public enum OrderStatus {
	        PENDING, CREATED, SHIPPED, DELIVERED, CANCELLED
	    }

		public Order() {
			super();
		}

		public Order(Long id, Long userId, LocalDateTime orderDate, OrderStatus status, Double totalAmount,
				List<OrderItem> items) {
			super();
			this.id = id;
			this.userId = userId;
			this.orderDate = orderDate;
			this.status = status;
			this.totalAmount = totalAmount;
			this.items = items;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Long getUserId() {
			return userId;
		}

		public void setUserId(Long userId) {
			this.userId = userId;
		}

		public LocalDateTime getOrderDate() {
			return orderDate;
		}

		public void setOrderDate(LocalDateTime orderDate) {
			this.orderDate = orderDate;
		}

		public OrderStatus getStatus() {
			return status;
		}

		public void setStatus(OrderStatus status) {
			this.status = status;
		}

		public Double getTotalAmount() {
			return totalAmount;
		}

		public void setTotalAmount(Double totalAmount) {
			this.totalAmount = totalAmount;
		}

		public List<OrderItem> getItems() {
			return items;
		}

		public void setItems(List<OrderItem> items) {
			this.items = items;
		}

		@Override
		public String toString() {
			return "Order [id=" + id + ", userId=" + userId + ", orderDate=" + orderDate + ", status=" + status
					+ ", totalAmount=" + totalAmount + "]";
		}
	    
}
