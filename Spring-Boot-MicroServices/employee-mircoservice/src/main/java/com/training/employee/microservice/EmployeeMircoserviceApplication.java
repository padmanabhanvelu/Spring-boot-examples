package com.training.employee.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class EmployeeMircoserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeMircoserviceApplication.class, args);
	}

}
