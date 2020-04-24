package com.training.employee.microservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.employee.microservice.entity.Employee;
import com.training.employee.microservice.entity.Item;
import com.training.employee.microservice.repo.ItemCriteriaRepo;

@RestController
@RequestMapping(value = "/item")
public class ItemController {

	@Autowired
	ItemCriteriaRepo itemRepo;
	
	/*
	 * @GetMapping("/findAll") public List<Item> findAll() {
	 * 
	 * List<Item> items = itemRepo.buildQuery(); return items; }
	 */
	
	@GetMapping("/findAll")
	public Item[] findAll() {
		
		List<Item> items = itemRepo.buildQuery();
		return items.stream().toArray(Item[]::new);
	}
}

