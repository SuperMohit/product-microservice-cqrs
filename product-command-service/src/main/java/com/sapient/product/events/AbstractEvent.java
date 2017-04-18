package com.sapient.product.events;

import java.io.Serializable;

public class AbstractEvent implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6490616503944614637L;
	
	private String id;

	public AbstractEvent() {
	}

	public AbstractEvent(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

}
