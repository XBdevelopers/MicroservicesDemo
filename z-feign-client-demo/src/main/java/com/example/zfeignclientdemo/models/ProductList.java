package com.example.zfeignclientdemo.models;

import java.util.List;

public class ProductList {

	private List<Product> productList;
	private String service;

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}
	
}
