package com.example.zfeignclientdemo.client;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.zfeignclientdemo.configurations.DemoConfiguration;
import com.example.zfeignclientdemo.models.ProductList;


//@RibbonClient(name = "demo", configuration = DemoConfiguration.class)
//@FeignClient(value="demo", url = "http://localhost:9091/")
@FeignClient(value="demo")
@RibbonClient(name = "demo")
public interface FeignClientInterface {

	@RequestMapping("/data")
	public ProductList findProducts();
	
	@RequestMapping("/data/id")
	public ProductList getProducts(int id);
}
