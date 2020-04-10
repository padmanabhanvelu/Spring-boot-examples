package com.student.studentsample.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.student.studentsample.entity.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {

	
}
