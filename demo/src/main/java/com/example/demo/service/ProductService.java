package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ProductDao;
import com.example.demo.model.Product;

@Service
public class ProductService {

	@Autowired
	private ProductDao productDao;
	
	public int addNumbers(int a, int b) {
		return a+b;
	}
	
	// Get All Products
	public List<Product> getAllData(){
		return productDao.fetchAllData();
	}
	
	// Get a Product by id
	public Product getProduct(int id) {
		return productDao.getProductInfoById(id);
	}
	
	// Get Multiple products by a list of IDs
	public List<Product> getProducts(List<Integer> list){
		return productDao.getMultipleProducts(list);
	}
	
	// Update product info
	public Product updateProduct(Product product) {
		return productDao.updateProduct(product);
	}
	
	// Insert a product
	public Product addProduct(Product product) {
		return productDao.insertProduct(product);
	}
	
	// Delete a Product
	public boolean deleteProduct(int id) {
		return productDao.removeProduct(id);
	}
	
	// Custom Query - Native Query
 	public Product getProductById(int id) {
		return productDao.getProductById(id);
	}
}
