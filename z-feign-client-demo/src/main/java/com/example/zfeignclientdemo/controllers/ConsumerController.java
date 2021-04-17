package com.example.zfeignclientdemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.zfeignclientdemo.client.FeignClientInterface;
import com.example.zfeignclientdemo.models.ProductList;

@RestController
public class ConsumerController {
	
	@Autowired
	private FeignClientInterface feign;
	
	@Autowired
	private Environment env;

	@RequestMapping("/")
	public String getWelcomeMessage() {
		return "Welcome to Microservice: Feign Client";
	}
	
	@RequestMapping("/feign/data")
	public ResponseEntity<ProductList> getAllProductsList() {
		ProductList products = feign.findProducts();
		products.setService("Feign-Client: "+env.getProperty("local.server.port"));
		return new ResponseEntity<>(products,HttpStatus.OK);
	}
}
