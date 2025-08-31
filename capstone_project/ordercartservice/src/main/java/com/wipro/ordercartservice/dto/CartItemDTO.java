package com.wipro.ordercartservice.dto;

public class CartItemDTO {
	 	private Long id;
	    private Long userId;
	    private Long productId;
	    private Integer quantity;
	    private Double price;
	    private String productName;
		
	    
	    public CartItemDTO() {
			super();
		}
		public CartItemDTO(Long id, Long userId, Long productId, Integer quantity, Double price, String productName) {
			super();
			this.id = id;
			this.userId = userId;
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
		public Long getUserId() {
			return userId;
		}
		public void setUserId(Long userId) {
			this.userId = userId;
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
			return "CartItemDTO [id=" + id + ", userId=" + userId + ", productId=" + productId + ", quantity="
					+ quantity + ", price=" + price + ", productName=" + productName + "]";
		}
		
	    

}
