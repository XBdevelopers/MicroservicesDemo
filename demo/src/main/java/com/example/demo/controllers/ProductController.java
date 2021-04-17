package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Product;
import com.example.demo.model.ProductList;
import com.example.demo.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	ProductService service;
	
	@RequestMapping("/")
	public String welcome() {
		return "Welcome to Microservice: Hemeshwary";
	}
	
	@RequestMapping("/data")
	public ProductList getData(){
		ProductList list = new ProductList();
		list.setProductList(service.getAllData());
		return list;
	}
	
	@RequestMapping("/data/{id}")
	public String getProductName(@PathVariable("id")int id) {
		return service.getProductById(id).toString();	// By Native Query
		// Or
		// return service.getProduct(id);
	}
	
	public List<Product> getMultipleProducts(List<Integer> list){
		return service.getProducts(list);
	}
	
	@RequestMapping("/data/update/{id}/{name}/{type}")
	public Product updateProduct(@PathVariable("id")int id, @PathVariable("name")String name, @PathVariable("type")String type) {
		Product product = new Product();
		product.setId(id);
		product.setName(name);
		product.setType(type);
		return service.updateProduct(product);
	}
	
	
	@RequestMapping("/data/add/{name}/{type}")
	public Product addProduct(@PathVariable("name") String name, @PathVariable("type") String type) {
		Product product = new Product();
		product.setId(0);
		product.setName(name);
		product.setType(type);
		return service.addProduct(product);
	}
	 
	
	/*
	 * @PutMapping("/data/add") public Product addProduct(@RequestBody Product
	 * product) { return service.addProduct(product); }
	 */
	
	@RequestMapping("/data/remove/{id}")
	public String removeProduct(@PathVariable("id")int id) {
		Boolean status = service.deleteProduct(id);
		if (status) 
			return "Success";
		else
			return "Failed";
	}
	
	@RequestMapping("/addition/{x}/{b}")
	public int getAddService(@PathVariable("x") int a, @PathVariable("b") int b) {
		return service.addNumbers(a, b);
	}
}
