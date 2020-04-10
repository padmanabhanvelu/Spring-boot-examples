package com.training.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="tbl_employee")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Employee {


	@Id
	@Column(name="emp_id")
	private Long empId;
	
	@Column
	private String name;
	
	@Column
	private String emailId;
	
	@Column
	private String department;
	

	@Column
	private Long salary;
	
	

	
}
