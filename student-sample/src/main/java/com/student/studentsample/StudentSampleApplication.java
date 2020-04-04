package com.student.studentsample;

import javax.transaction.Transactional;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.student.studentsample.entity.Student;
import com.student.studentsample.repo.StudentRepo;

@SpringBootApplication
public class StudentSampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentSampleApplication.class, args);
	}
	
	
	@Bean
    ApplicationRunner init(StudentRepo repository) {
        return (ApplicationArguments args) ->  dataSetup(repository);
    } 

	@Transactional
    public void dataSetup(StudentRepo repository){
   
    	Student student = new Student(1L,"Student1");
    	repository.save(student);
    	System.out.println("student :"+repository.findAll());
    }

}
