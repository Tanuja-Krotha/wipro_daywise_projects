package com.wipro.productmanagement.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wipro.productmanagement.dto.Product;

public interface ProductServiceI {
	
	void save(Product product);
	
	List<Product> getAllProducts();
	
	Product findById(int id);
	
	void deleteById(int id);
	
	List<Product> findByProductMake(String productMake);
	
	List<Product> findByProductNameAndProductMakeOrderByProductNameDesc(String productName,String productMake);

	Page<Product> findAll(Pageable p);
}
