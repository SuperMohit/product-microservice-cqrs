package com.sapient.product.aggregates;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.spring.stereotype.Aggregate;

import com.sapient.product.command.AddProductCommand;
import com.sapient.product.events.ProductAddedEvent;
import static org.axonframework.commandhandling.model.AggregateLifecycle.apply;


@Aggregate
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
