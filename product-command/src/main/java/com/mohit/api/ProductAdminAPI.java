package com.sapient.api;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.sapient.product.command.AddProductCommand;

@RestController
public class ProductAdminAPI {
	
	@Autowired
	private CommandGateway commandGateway;

	@PostMapping("/add")
	public CompletableFuture<String> addProduct(@RequestBody Map<String, String> request){
		return commandGateway.send(new AddProductCommand(UUID.randomUUID().toString(), request.get("name")));		
	}

	@Bean
    public Exchange exchange(){
         return ExchangeBuilder.fanoutExchange("ProductEvents").build();
    }
	
	@Bean
    public Queue queue(){
    	return QueueBuilder.durable("ProductEvents").build();
    }
	
	@Bean
	public Binding binding(){
		return BindingBuilder.bind(queue()).to(exchange()).with("*").noargs();		
	}
	
	public void configure(AmqpAdmin admin){
		admin.declareQueue(queue());
		admin.declareExchange(exchange());
		admin.declareBinding(binding());
	}
    
}


