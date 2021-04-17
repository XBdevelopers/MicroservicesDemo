package com.example.demo.dao;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.model.Product;

@Component
@Transactional
public class ProductDao {
	
	@Autowired
	private ProductRepository repository;
	
	// Fetch all rows
	public List<Product> fetchAllData(){
		List<Product> dataList = repository.findAll();
		return dataList;
	}
	
	// Fetch a row by id
	public Product getProductInfoById(int id) {
		Optional<Product> p = repository.findById(id);
		if(p.isPresent()) {
			Product product = (Product) p.get();
			return product;
		}else
			return new Product();
	}
	
	// Fetch multiple rows by a list of Ids
	public List<Product> getMultipleProducts(List<Integer> id){
		List<Product> list = repository.findAllById(id);
		return list;
	}
	
	// Update/Merge a row
	public Product updateProduct(Product product) {
		Optional<Product> p = repository.findById(product.getId());
		if (p.isPresent()) {
			Product updatedProduct = repository.save(product);
			return updatedProduct;
		}else
			return new Product();
	}
	
	// Create a row
	public Product insertProduct(Product product) {
		return repository.save(product);
	}
	
	// Remove a row
	public boolean removeProduct(int id) {
		repository.deleteById(id);
		return true;
	}
	
	// Custom Query - Native Query
	public Product getProductById(int id) {
		Optional<Product> product = repository.getProductById(id);
		if(product.isPresent())
			return product.get();
		else {
			Product retProd = new Product();
			retProd.setId(000);
			retProd.setName("Bliss..");
			retProd.setType("Default");
			return retProd;
		}
	}
}
