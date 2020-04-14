package com.training.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.training.entity.Item;

@Repository
public interface ItemRepo extends JpaRepository<Item, Long> {
	
	
	
}
