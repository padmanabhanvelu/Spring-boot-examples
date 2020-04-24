package com.training.employee.microservice.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="tbl_department")
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Department {

	
	@Id
	@Column(name="department_id")
	private Long departmentId;
	
	@Column
	private String departmentName;
	
	@Column
	private String description;
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy = "department",cascade = CascadeType.REFRESH)
	private List<Employee> employees;
}
