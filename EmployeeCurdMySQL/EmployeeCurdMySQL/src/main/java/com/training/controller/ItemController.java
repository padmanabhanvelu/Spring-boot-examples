package com.training.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.training.entity.Item;
import com.training.repo.ItemCriteriaRepo;

@RestController
@RequestMapping(value = "/item")
public class ItemController {

	@Autowired
	ItemCriteriaRepo itemRepo;
	
	@GetMapping("/findAll")
	public List<Item> findAll() {
		
		List<Item> items = itemRepo.buildQuery();
		return items;
	}
}

