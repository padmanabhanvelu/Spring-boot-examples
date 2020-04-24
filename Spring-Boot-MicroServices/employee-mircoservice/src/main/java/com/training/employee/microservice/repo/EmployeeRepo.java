package com.training.employee.microservice.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.training.employee.microservice.entity.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {
	
	
	@Query(value="select em from Employee em inner join fetch em.department  where em.empId=:empId")
	Employee getEmployeeById(@Param("empId") Long empId);
	
	@Query(value = "SELECT * FROM tbl_employee u WHERE u.empId = :empId", nativeQuery = true)
	List<Employee> findAllActiveUsersNative(@Param("empId") Long empId);
	
	List<Employee> findByDepartmentDepartmentName(String name);
	
	List<Employee> findBySalaryBetween(Long val1, Long val2); 

	List<Employee> findByDepartmentAndName(String dept,String name);
	
	List<Employee> findByNameContainingIgnoreCase(String name);
}
