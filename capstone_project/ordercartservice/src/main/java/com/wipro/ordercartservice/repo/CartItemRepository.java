package com.wipro.ordercartservice.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wipro.ordercartservice.entity.CartItem;
@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {
	 	List<CartItem> findByUserId(Long userId);
	    void deleteByUserId(Long userId);
	    CartItem findByUserIdAndProductId(Long userId, Long productId);
}
