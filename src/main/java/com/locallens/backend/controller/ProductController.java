package com.locallens.backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.locallens.backend.entity.Product;
import com.locallens.backend.service.ProductService;
@RestController
@RequestMapping("/api/products")
public class ProductController {
	private ProductService productService ;
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	@PostMapping
	public Product createProduct(@RequestBody Product product) {
		return productService.saveProduct(product);
	}
	@GetMapping
	public List<Product>getAllProducts(){
		return productService.getAllProducts();
	}
	@PutMapping("/{id}")
	public Product updateProduct(@PathVariable Long id,
	                             @RequestBody Product product) {
	    Product existingProduct = productService.getProductById(id);

	    existingProduct.setName(product.getName());
	    existingProduct.setBrand(product.getBrand());
	    existingProduct.setCategory(product.getCategory());
	    existingProduct.setPrice(product.getPrice());
	    existingProduct.setStock(product.getStock());

	    return productService.saveProduct(existingProduct);
	}
	
	
}
