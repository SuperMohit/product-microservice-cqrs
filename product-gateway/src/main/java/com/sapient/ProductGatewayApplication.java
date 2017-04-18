package com.sapient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.system.ApplicationPidFileWriter;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.sapient.filter.PreFilter;

@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
public class ProductGatewayApplication {
	
	public static void main(String[] args) {
		SpringApplication productgatewayService = new SpringApplication(ProductGatewayApplication.class);
        productgatewayService.addListeners(new ApplicationPidFileWriter("product-gateway-service.pid"));
        productgatewayService.run(args);
	}
	
	  @Bean
	  public PreFilter simpleFilter() {
	    return new PreFilter();
	  }

	
}
