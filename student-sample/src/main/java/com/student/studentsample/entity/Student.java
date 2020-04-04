package com.student.studentsample.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_student")
public class Student {

	public Student(Long studentId, String name) {
		this.studentId = studentId;
		this.name = name;
	}
	
	public Student() {
		
	}
	
	
	

	



	@Id
	@Column(name="student_id")
	private Long studentId;
	
	@Column
	private String name;
	
	@Column
	private String department;
	

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", name=" + name + "]";
	}
	
	
	
	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
}
