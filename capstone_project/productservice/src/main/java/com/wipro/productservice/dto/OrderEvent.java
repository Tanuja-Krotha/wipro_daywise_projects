package com.wipro.productservice.dto;

public class OrderEvent {
	private String type;
    private Long productId;
    private Integer quantity;
    private Long orderId;
	
    
    public OrderEvent()
    {
    	super();
    }
    
    public OrderEvent(String type, Long productId, Integer quantity, Long orderId) {
		super();
		this.type = type;
		this.productId = productId;
		this.quantity = quantity;
		this.orderId = orderId;
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
	@Override
	public String toString() {
		return "OrderEvent [type=" + type + ", productId=" + productId + ", quantity=" + quantity + ", orderId="
				+ orderId + "]";
	}
    

}
