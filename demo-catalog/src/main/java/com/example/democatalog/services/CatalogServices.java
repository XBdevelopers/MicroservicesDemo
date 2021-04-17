package com.example.democatalog.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.democatalog.model.Product;
import com.example.democatalog.model.ProductList;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class CatalogServices {

	@Autowired
	private RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod = "getDataFallback")
	  public ProductList getData(){
		  String uri = "http://demo/data/";
		  return restTemplate.getForObject(uri, ProductList.class);
	  }
	 
	public ProductList getDataFallback() {
		Product product = new Product();
		product.setId(0);
		product.setName("Fallback");
		List<Product> list = new ArrayList<>();
		list.add(product);
		ProductList p= new ProductList();
		p.setProductList(list);
		return p; 
	}
}
