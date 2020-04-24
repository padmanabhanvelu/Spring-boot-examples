package com.training.edge.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class EdgeMircoserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EdgeMircoserviceApplication.class, args);
	}

}
