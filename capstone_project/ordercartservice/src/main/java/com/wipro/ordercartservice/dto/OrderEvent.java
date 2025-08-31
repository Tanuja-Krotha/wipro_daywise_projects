package com.wipro.ordercartservice.dto;

import java.time.LocalDateTime;

public class OrderEvent {
	 private String type; // ORDER_CREATED, ORDER_CANCELLED, etc.
	    private Long productId;
	    private Integer quantity;
	    private Long orderId;
	    
	    // Optional: Add timestamps for better tracking
	    private java.time.LocalDateTime timestamp;
	    private Long userId;
		
	    public OrderEvent() {
			super();
		}

		public OrderEvent(String type, Long productId, Integer quantity, Long orderId, LocalDateTime timestamp,
				Long userId) {
			super();
			this.type = type;
			this.productId = productId;
			this.quantity = quantity;
			this.orderId = orderId;
			this.timestamp = timestamp;
			this.userId = userId;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public Long getProductId() {
			return productId;
		}

		public void setProductId(Long productId) {
			this.productId = productId;
		}

		public Integer getQuantity() {
			return quantity;
		}

		public void setQuantity(Integer quantity) {
			this.quantity = quantity;
		}

		public Long getOrderId() {
			return orderId;
		}

		public void setOrderId(Long orderId) {
			this.orderId = orderId;
		}

		public java.time.LocalDateTime getTimestamp() {
			return timestamp;
		}

		public void setTimestamp(java.time.LocalDateTime timestamp) {
			this.timestamp = timestamp;
		}

		public Long getUserId() {
			return userId;
		}

		public void setUserId(Long userId) {
			this.userId = userId;
		}

		@Override
		public String toString() {
			return "OrderEvent [type=" + type + ", productId=" + productId + ", quantity=" + quantity + ", orderId="
					+ orderId + ", timestamp=" + timestamp + ", userId=" + userId + "]";
		}
		
	    

}
