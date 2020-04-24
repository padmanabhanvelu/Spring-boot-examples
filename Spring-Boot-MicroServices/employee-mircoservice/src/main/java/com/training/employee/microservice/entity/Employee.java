package com.training.employee.microservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
	
	@Column(name="department_id")
	private Long departmentId;
	

	@Column
	private Long salary;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="department_id", insertable = false,updatable = false)
	private Department department;

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", emailId=" + emailId + ", departmentId=" + departmentId
				+ ", salary=" + salary + "]";
	}
	
	
	
	

	
}
