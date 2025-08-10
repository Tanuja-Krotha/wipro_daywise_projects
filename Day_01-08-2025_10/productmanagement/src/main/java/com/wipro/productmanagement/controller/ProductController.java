package com.wipro.productmanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.productmanagement.dto.Product;
import com.wipro.productmanagement.service.ProductServiceI;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
@Tag(name = "Product", description = "Product management APIs")
@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	ProductServiceI productServiceI;
	
	
	@Operation(summary = "Save a Product")
	@ApiResponses(value = {
	@ApiResponse(responseCode = "200", description = "Saved successfully"),
	@ApiResponse(responseCode = "404", description = "Not found")
	  })
	@PostMapping
	void save(@RequestBody Product product)
	{
		productServiceI.save(product);
	}
	
	@GetMapping
	List<Product> getAllProducts()
	{
		return productServiceI.getAllProducts();
		
	}
	
	
	@GetMapping("/{id}")
	Product findById(@PathVariable int id)
	{
		return productServiceI.findById(id);
		
	}
	
	@PutMapping("/{id}")
	void update(@RequestBody Product product)
	{
		productServiceI.save(product);
		
	}
	
	@DeleteMapping("/{id}")
	void deleteById(@PathVariable int id)
	{
		productServiceI.deleteById(id);
		
	}
	
	@GetMapping("/make/{productMake}")
	List<Product> findByProductMake(@PathVariable String productMake)
	{
		return productServiceI.findByProductMake(productMake);
	}
	
	@GetMapping("/search/{productName}/{productMake}")
	List<Product> findByProductNameAndProductMakeOrderByProductNameDesc(@PathVariable String productName,@PathVariable String productMake)
	{
		return productServiceI.findByProductNameAndProductMakeOrderByProductNameDesc(productName, productMake);
	}
	
	@GetMapping("/page/{pageNum}/{pageSize}/{sortOrder}")
	public Page<Product> getAllPage(@PathVariable int  pageNum,@PathVariable int  pageSize,@PathVariable int  sortOrder)
	{
		Pageable p = null;
		  if(sortOrder==0)
		  {
			  p=PageRequest.of(pageNum, pageSize,Sort.by("productPrice").descending());
		  }
		  else
		  {
			    p=PageRequest.of(pageNum, pageSize,Sort.by("productPrice").ascending());
		  }
			
			return productServiceI.findAll(p);
	}
	
}
