package com.wipro.ordercartservice.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.wipro.ordercartservice.entity.Order.OrderStatus;

public class OrderDTO {
	private Long id;
    private Long userId;
    private LocalDateTime orderDate;
    private OrderStatus status;
    private Double totalAmount;
    private List<OrderItemDTO> items;
	
    public OrderDTO() {
		super();
	}

	public OrderDTO(Long id, Long userId, LocalDateTime orderDate, OrderStatus status, Double totalAmount,
			List<OrderItemDTO> items) {
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

	public List<OrderItemDTO> getItems() {
		return items;
	}

	public void setItems(List<OrderItemDTO> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "OrderDTO [id=" + id + ", userId=" + userId + ", orderDate=" + orderDate + ", status=" + status
				+ ", totalAmount=" + totalAmount + "]";
	}
    

}
