package com.wipro.ordercartservice.service;

import java.util.List;

import com.wipro.ordercartservice.dto.CartItemDTO;
import com.wipro.ordercartservice.entity.CartItem;

public interface CartService {
	CartItem addToCart(CartItemDTO cartItemDTO);
   
	void removeFromCart(Long cartItemId);
    
	CartItem updateCartItemQuantity(Long cartItemId, Integer quantity);
    
	List<CartItem> getCartByUserId(Long userId);
    
	void clearCart(Long userId);

}
