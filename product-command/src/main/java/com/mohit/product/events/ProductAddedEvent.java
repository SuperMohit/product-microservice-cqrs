package com.sapient.product.events;

public class ProductAddedEvent extends AbstractEvent {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3575107153371124897L;

	private String name;

	public ProductAddedEvent() {
	}

	public ProductAddedEvent(String id, String name) {
		super(id);
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
