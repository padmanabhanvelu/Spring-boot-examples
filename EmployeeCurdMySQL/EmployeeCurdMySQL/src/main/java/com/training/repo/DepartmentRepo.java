package com.training.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.training.entity.Department;

@Repository
public interface DepartmentRepo extends JpaRepository<Department, Long> {
	
	
	
}
