package com.training.microservice.studentmicroservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.training.microservice.studentmicroservice.entity.Student;
import com.training.microservice.studentmicroservice.repo.StudentRepo;

@RestController
@RequestMapping(value = "/student")
public class StudentController {

	
	@Autowired
	StudentRepo studentRepo;
	
	@GetMapping("/")
	public String home() { 
		
		return "My First Project";
	}
	
	@GetMapping("/findAll")
	public List<Student> findAll() { 
		return studentRepo.findAll();
	}
	
	@GetMapping("/findById/{id}")
	public Student findAll(@PathVariable long id) { 
		Optional<Student> student= studentRepo.findById(id);
		 if(student.isPresent()) {
			 return student.get();
		 }
		 else  {
			 return null; 
		 }
	}
	
	@GetMapping("/getById")
	public Student findById(@RequestParam(name="id") long id) { 
		Optional<Student> student= studentRepo.findById(id);
		 if(student.isPresent()) {
			 return student.get();
		 }
		 else  {
			 return null; 
		 }
	}
	
	
	@PostMapping(value = "/save", consumes= {"application/json"}, produces = {"application/json"})
	public String save(@RequestBody Student student) {
		Student st = studentRepo.save(student);
		if(null != st) {
			return "Saved Successfully";
		}
		return "Failed To Save";
	}
	
	
	
	@PutMapping(value = "/update", consumes= {"application/json"})
	public String update(@RequestBody Student student) {
		Student st = studentRepo.save(student);
		if(null != st) {
			return "Update Successfully";
		}
		return "Failed To Update";
	}
	
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable long id) { 
		studentRepo.deleteById(id);
		return "Deleted Successfully";
	}
	
	
}
