package com.demo.emp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.emp.domain.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {

}
