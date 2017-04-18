package com.mohit.api;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicLong;

import org.axonframework.config.ProcessingGroup;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mohit.product.events.ProductAddedEvent;

@RestController
@ProcessingGroup("productEvents")
public class ProductQueryAPI {
	
	private ConcurrentMap<String, AtomicLong> data = new ConcurrentHashMap<>(); 
	
	@EventHandler
	public void on(ProductAddedEvent event){
		data.computeIfAbsent(event.getName(), k -> new AtomicLong()).incrementAndGet();
	}

	@GetMapping("/products")
	public ConcurrentMap<String, AtomicLong> getData() {
		return data;
	}

	

}
