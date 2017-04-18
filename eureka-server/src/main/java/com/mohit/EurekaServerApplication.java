package com.mohit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.system.ApplicationPidFileWriter;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServerApplication {
	public static void main(String[] args) {
		SpringApplication eurekaServer = new SpringApplication(EurekaServerApplication.class);
		eurekaServer.addListeners(new ApplicationPidFileWriter("eureka-server.pid"));
		eurekaServer.run(args);
	}
}
