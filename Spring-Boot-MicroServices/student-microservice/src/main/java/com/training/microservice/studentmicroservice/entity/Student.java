package com.training.microservice.studentmicroservice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="tbl_student")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Student {


	@Id
	@Column(name="student_id")
	private Long studentId;
	
	@Column
	private String name;
	
	@Column
	private String department;
	

	

	
}
