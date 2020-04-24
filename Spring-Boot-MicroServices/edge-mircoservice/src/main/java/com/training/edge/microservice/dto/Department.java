package com.training.edge.microservice.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Department {

	
	private Long departmentId;
	
	private String departmentName;
	
	private String description;
	
	private List<Employee> employees;
}
