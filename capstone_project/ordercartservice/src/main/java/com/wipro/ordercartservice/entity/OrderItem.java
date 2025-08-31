package com.wipro.ordercartservice.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "order_items")
public class OrderItem {
	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    
	    @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name = "order_id", nullable = false)
	    private Order order;
	    
	    @Column(name = "product_id", nullable = false)
	    private Long productId;
	    
	    @Column(nullable = false)
	    private Integer quantity;
	    
	    @Column(nullable = false)
	    private Double price;
	    
	    @Column(name = "product_name", nullable = false)
	    private String productName;
	    
	    
	    public OrderItem() {
			super();
		}

		public OrderItem(Long id, Order order, Long productId, Integer quantity, Double price, String productName) {
			super();
			this.id = id;
			this.order = order;
			this.productId = productId;
			this.quantity = quantity;
			this.price = price;
			this.productName = productName;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Order getOrder() {
			return order;
		}

		public void setOrder(Order order) {
			this.order = order;
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

		public Double getPrice() {
			return price;
		}

		public void setPrice(Double price) {
			this.price = price;
		}

		public String getProductName() {
			return productName;
		}

		public void setProductName(String productName) {
			this.productName = productName;
		}

		@Override
		public String toString() {
			return "OrderItem [id=" + id + ", order=" + order + ", productId=" + productId + ", quantity=" + quantity
					+ ", price=" + price + ", productName=" + productName + "]";
		}
		
	    

}
