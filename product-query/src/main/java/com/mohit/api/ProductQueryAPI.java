package com.mohit.api;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mohit.product.domain.ProductQueryObject;
import com.mohit.product.events.ProductAddedEvent;

@RestController
@ProcessingGroup("productEvents")
public class ProductQueryAPI {
	
	private ConcurrentMap<String, ProductQueryObject> data = new ConcurrentHashMap<>(); 
	
	@EventHandler
	public void on(ProductAddedEvent event){
		data.put(event.getId(), new ProductQueryObject(event.getId(), event.getName(), event.getPrice()));
		
	}

	@GetMapping("/products")
	public ConcurrentMap<String, ProductQueryObject> getData() {
		return data;
	}
   
	public ConcurrentMap<String, ProductQueryObject> getProducts(){
		return data;
	}

}
