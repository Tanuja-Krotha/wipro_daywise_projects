package com.wipro.productservice.service;

import java.util.List;

import com.wipro.productservice.dto.ProductDTO;
import com.wipro.productservice.entity.Product;

public interface ProductService {
	Product createProduct(ProductDTO productDTO);
    
	Product updateProduct(Long id, ProductDTO productDTO);
    
	void deleteProduct(Long id);
    
	List<Product> getAllProducts();
    
	Product getProductById(Long id);
    
	void updateProductQuantity(Long productId, Integer quantity);
	
    void decreaseStock(Long productId, int quantity);
    
    void increaseStock(Long productId, int quantity);
     
     

}
