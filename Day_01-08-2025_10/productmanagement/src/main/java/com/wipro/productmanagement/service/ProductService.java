package com.wipro.productmanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.wipro.productmanagement.dto.Product;
import com.wipro.productmanagement.repo.ProductRepo;

@Service
public class ProductService implements ProductServiceI{
	@Autowired
	ProductRepo productRepo;
	
	@Override
	public void save(Product product) 
	{
		productRepo.save(product);	
	}

	@Override
	public List<Product> getAllProducts() 
	{
		return productRepo.findAll();
	}

	@Override
	public Product findById(int id) 
	{
		Optional<Product> product = productRepo.findById(id);
		if(!product.isEmpty())
		{
			return product.get();
		}
		return null;
	}

	@Override
	public void deleteById(int id)
	{
		productRepo.deleteById(id);
	}

	@Override
	public List<Product> findByProductMake(String productMake) {
		
		return productRepo.findByProductMake(productMake);
	}

	@Override
	public List<Product> findByProductNameAndProductMakeOrderByProductNameDesc(String productName, String productMake) {
		
		return productRepo.findByProductNameAndProductMakeOrderByProductNameDesc(productName, productMake);
	}

	@Override
	public Page<Product> findAll(Pageable p) {
		return productRepo.findAll(p);
	}

}
