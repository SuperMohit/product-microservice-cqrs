package com.sapient.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.sapient.product.domain.ProductQueryObject;
import com.sapient.product.events.ProductAddedEvent;
import com.sapient.product.repository.ProductQueryObjectRepository;

@Component
public class ProductObjectQueryUpdater {	
	@Autowired
	private ProductQueryObjectRepository productRepository;
	
	public void on(ProductAddedEvent event){
		productRepository.save(new ProductQueryObject(event.getId(), event.getName()));
	}
	
}
