package com.demo.emp.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Employee {

	@Id
	@Column(name = "EMP_ID")
	private Long empId;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "SALARY")
	private Long salary;
	
	@Column(name = "DEPARTMENT")
	private String department;
}
