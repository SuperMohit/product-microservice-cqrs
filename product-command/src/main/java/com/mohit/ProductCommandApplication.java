package com.sapient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.system.ApplicationPidFileWriter;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ProductCommandApplication {

	public static void main(String[] args) {
		SpringApplication productCommandService = new SpringApplication(ProductCommandApplication.class);
        productCommandService.addListeners(new ApplicationPidFileWriter("product-command-service.pid"));
        productCommandService.run(args);
	}
}
