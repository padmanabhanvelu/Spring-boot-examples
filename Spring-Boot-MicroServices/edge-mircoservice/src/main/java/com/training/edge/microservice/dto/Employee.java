package com.training.edge.microservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data

public class Employee {


	private Long empId;
	
	private String name;
	
	private String emailId;
	
	private Long departmentId;
	

	private Long salary;
	
	private Department department;

	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", emailId=" + emailId + ", departmentId=" + departmentId
				+ ", salary=" + salary + "]";
	}
	
	
	
	

	
}
