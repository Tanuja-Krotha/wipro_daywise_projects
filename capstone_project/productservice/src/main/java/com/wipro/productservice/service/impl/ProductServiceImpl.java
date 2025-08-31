package com.wipro.productservice.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.wipro.productservice.dto.ProductDTO;
import com.wipro.productservice.entity.Product;
import com.wipro.productservice.repo.ProductRepository;
import com.wipro.productservice.service.ProductService;

import jakarta.transaction.Transactional;

@Service
public class ProductServiceImpl implements ProductService {
    
    @Autowired
    private ProductRepository productRepository;
    
    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;
    
    @Override
    public Product createProduct(ProductDTO productDTO) {
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setQuantity(productDTO.getQuantity());
        product.setImageUrl(productDTO.getImageUrl()); // Directly set the image URL
        
        return productRepository.save(product);
    }
    
    @Override
    public Product updateProduct(Long id, ProductDTO productDTO) {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
        
        existingProduct.setName(productDTO.getName());
        existingProduct.setDescription(productDTO.getDescription());
        existingProduct.setPrice(productDTO.getPrice());
        existingProduct.setQuantity(productDTO.getQuantity());
        
        // Update image URL if provided
        if (productDTO.getImageUrl() != null && !productDTO.getImageUrl().isEmpty()) {
            existingProduct.setImageUrl(productDTO.getImageUrl());
        }
        
        return productRepository.save(existingProduct);
    }
    
    @Override
    public void deleteProduct(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
        
        productRepository.delete(product);
    }
    
    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    
    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
    }
    
    @Override
    @Transactional
    public void updateProductQuantity(Long productId, Integer quantityChange) {
        try {
            Product product = getProductById(productId);
            
            int newQuantity = product.getQuantity() + quantityChange;
            if (newQuantity < 0) {
                throw new RuntimeException("Insufficient inventory for product: " + productId);
            }
            
            product.setQuantity(newQuantity);
            productRepository.save(product);
            
            System.out.println("Updated product: " + productId + 
                              ", quantity change: " + quantityChange + 
                              ", new quantity: " + newQuantity);
        } catch (Exception e) {
            System.err.println("Error updating product quantity: " + e.getMessage());
            throw e;
        }
    }
    
    @Override
    public void decreaseStock(Long productId, int quantity) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("Product not found: " + productId));

        if (product.getQuantity() < quantity) {
            throw new IllegalStateException("Insufficient stock for product: " + productId);
        }

        product.setQuantity(product.getQuantity() - quantity);
        productRepository.save(product);

        System.out.println("Stock decreased for product " + productId);
    }
    
    @Override
    public void increaseStock(Long productId, int quantity) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("Product not found: " + productId));

        product.setQuantity(product.getQuantity() + quantity);
        productRepository.save(product);

        System.out.println("Stock increased for product " + productId);
    }
}