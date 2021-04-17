package com.example.democatalog.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.democatalog.model.ProductList;
import com.example.democatalog.services.CatalogServices;

@RestController
public class ProductCatalog {

	@Autowired
	private CatalogServices catalogServices;
	
	@RequestMapping("/")
	public String getWelcomeMessage() {
		return "Welcome to Microservice: Demo-Catalog";
	}
	
	@RequestMapping("/catalog")
	public ResponseEntity<ProductList> getAllProductsList() {
		ProductList products = catalogServices.getData();
		return new ResponseEntity<>(products,HttpStatus.OK);
	}
}
