package com.training.employee.microservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.training.employee.microservice.entity.Item;

@Repository
public interface ItemRepo extends JpaRepository<Item, Long> {
	
	
	
}
