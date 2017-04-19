package com.mohit.product.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ProductQueryObject {
	
	@Id
	private String productId;	
	private String description;
	private final long price;

	public ProductQueryObject(String productId, String description, long price) {
		super();
		this.productId = productId;
		this.description = description;
		this.price = price;
	}
	
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public long getPrice() {
		return price;
	}
	

}
