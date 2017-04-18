package com.mohit;

import org.axonframework.amqp.eventhandling.DefaultAMQPMessageConverter;
import org.axonframework.amqp.eventhandling.spring.SpringAMQPMessageSource;
import org.axonframework.serialization.Serializer;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.system.ApplicationPidFileWriter;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import com.rabbitmq.client.Channel;

@SpringBootApplication
@EnableEurekaClient
public class ProductQueryApplication {

	public static void main(String[] args) {
		SpringApplication productQueryService = new SpringApplication(ProductQueryApplication.class);
        productQueryService.addListeners(new ApplicationPidFileWriter("product-query-service.pid"));
        productQueryService.run(args);
	}
	

	@Bean
	public SpringAMQPMessageSource productEvents(Serializer serializer) {
		return new SpringAMQPMessageSource(new DefaultAMQPMessageConverter(serializer)) {
			
			@RabbitListener(queues="ProductEvents")
			@Override
			public void onMessage(Message message, Channel channel) throws Exception {
				super.onMessage(message, channel);
			}
		};
	}

	
	
}
