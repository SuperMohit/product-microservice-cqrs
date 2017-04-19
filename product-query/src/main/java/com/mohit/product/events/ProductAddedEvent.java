package com.mohit.product.events;

public class ProductAddedEvent extends AbstractEvent {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3575107153371124897L;

	private String name;
	private long price;

	public ProductAddedEvent() {
	}

	public ProductAddedEvent(String id, String name, long price) {
		super(id);
		this.name = name;
		this.setPrice(price);
	}

	public String getName() {
		return name;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}
}
