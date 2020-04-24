package com.training.microservice.studentmicroservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.training.microservice.studentmicroservice.entity.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {

	
}
