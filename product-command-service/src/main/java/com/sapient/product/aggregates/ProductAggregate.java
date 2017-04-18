package com.sapient.product.aggregates;




public class ProductAggregate {
	

    @AggregateIdentifier
    private String id;
    private String name;
    
    public ProductAggregate() {
    }
    
    @CommandHandler
    public ProductAggregate(AddProductCommand command) {
       apply(new ProductAddedEvent(command.getId(), command.getName()));
    }
    
    @EventSourcingHandler
    public void on(ProductAddedEvent event) {
        this.id = event.getId();
        this.name = event.getName();
    }


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
    
    
	
	

}
