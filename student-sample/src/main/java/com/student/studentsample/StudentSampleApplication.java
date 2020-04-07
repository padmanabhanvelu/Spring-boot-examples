package com.student.studentsample;

import javax.transaction.Transactional;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.student.studentsample.entity.Employee;
import com.student.studentsample.repo.EmployeeRepo;

@SpringBootApplication
public class StudentSampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentSampleApplication.class, args);
	}
	
	
	/*
	 * @Bean ApplicationRunner init(StudentRepo repository) { return
	 * (ApplicationArguments args) -> dataSetup(repository); }
	 * 
	 * @Transactional public void dataSetup(StudentRepo repository){
	 * 
	 * Student student = new Student(1L,"Student1","Department");
	 * repository.save(student);
	 * System.out.println("student :"+repository.findAll()); }
	 */
	
	
	@Bean
    ApplicationRunner init(EmployeeRepo repository) {
        return (ApplicationArguments args) ->  dataSetup(repository);
    } 

	@Transactional
    public void dataSetup(EmployeeRepo repository){
   
    	Employee employee = new Employee(1L,"Employee1","Department",5000L);
    	repository.save(employee);
    	System.out.println("employee :"+repository.findAll());
    }

}
