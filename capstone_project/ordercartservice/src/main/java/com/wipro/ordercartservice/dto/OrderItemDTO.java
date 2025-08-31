package com.wipro.ordercartservice.dto;

public class OrderItemDTO {
	private Long productId;
    private Integer quantity;
    private Double price;
    private String productName;
	
    public OrderItemDTO() {
		super();
	}

	public OrderItemDTO(Long productId, Integer quantity, Double price, String productName) {
		super();
		this.productId = productId;
		this.quantity = quantity;
		this.price = price;
		this.productName = productName;
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
		return "OrderItemDTO [productId=" + productId + ", quantity=" + quantity + ", price=" + price + ", productName="
				+ productName + "]";
	}
	
    

}
