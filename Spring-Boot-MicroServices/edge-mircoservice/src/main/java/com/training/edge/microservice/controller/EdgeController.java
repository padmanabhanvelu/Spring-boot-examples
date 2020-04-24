package com.training.edge.microservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.training.edge.microservice.dto.Item;

@RestController
public class EdgeController {
	
	
	
	/*
	 * @GetMapping("/findAll") public List<?> findAll() {
	 * 
	 * //List<Employee> employees = employeeRepo.findAll();
	 * 
	 * final String uri = "http://localhost:8094/employee/findAll";
	 * 
	 * RestTemplate restTemplate = new RestTemplate();
	 * 
	 * Employee[] employees = restTemplate.getForObject(uri,Employee[].class);
	 * return Arrays.asList(employees); }
	 */

	
	@GetMapping("/findAll")
	public Item[] findAll() {
		
		final String uri = "http://localhost:8094/item/findAll";
		 
		RestTemplate restTemplate = new RestTemplate();
		
		Item[] items = restTemplate.getForObject(uri,Item[].class);
		return items;
	}
}
