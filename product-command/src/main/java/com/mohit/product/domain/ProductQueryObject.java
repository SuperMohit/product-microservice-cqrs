package com.sapient.product.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ProductQueryObject {
	
	@Id
	private String productId;	
	private String description;

	public ProductQueryObject(String productId, String description) {
		super();
		this.productId = productId;
		this.description = description;
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
	

}
