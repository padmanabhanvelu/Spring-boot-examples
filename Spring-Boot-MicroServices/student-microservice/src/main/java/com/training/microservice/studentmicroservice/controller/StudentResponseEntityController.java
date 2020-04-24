package com.training.microservice.studentmicroservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.training.microservice.studentmicroservice.entity.Student;
import com.training.microservice.studentmicroservice.repo.StudentRepo;

@RestController
@RequestMapping(value = "/student01")
public class StudentResponseEntityController {

	
	@Autowired
	StudentRepo studentRepo;
	
	@GetMapping("/")
	public ResponseEntity<String> home() { 
		
		return new ResponseEntity<String>("Hello World",HttpStatus.OK);
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<?> findAll() { 
		List<Student> studentlist = studentRepo.findAll();
		return new ResponseEntity<>(studentlist,HttpStatus.OK);
	}
	
	@GetMapping("/findById/{id}")
	public ResponseEntity<?> findAll(@PathVariable long id) { 
		Optional<Student> student= studentRepo.findById(id);
		 if(student.isPresent()) {
			 return new ResponseEntity<>(student.get(),HttpStatus.OK);
		 }
		 else  {
			 return new ResponseEntity<>("Student Id does not exists",HttpStatus.NOT_FOUND);
		 }
	}
	
	@PostMapping(value = "/getById", produces= {"application/json"})
	@ResponseBody
	public Student findById(@RequestParam(name="id") long id) { 
		Optional<Student> student= studentRepo.findById(id);
		 if(student.isPresent()) {
			 return student.get();
		 }
		 else  {
			 return null; 
		 }
	}
	
	
	@PostMapping(value = "/save", consumes= {"application/json"})
	public ResponseEntity<?> save(@RequestBody Student student) {
		Student st = studentRepo.save(student);
		if(null != st) {
			return ResponseEntity.created(null).body(st);
		}
		return new ResponseEntity<>("failed to Update",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	
	@PutMapping(value = "/update", consumes= {"application/json"})
	public ResponseEntity<?> update(@RequestBody Student student) {
		Student st = studentRepo.save(student);
		if(null != st) {
			return ResponseEntity.ok().header("Header01", "Test Header Value").body(st);
		}
		return new ResponseEntity<>("failed to Update",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	@PatchMapping(value = "/partialUpdate", consumes= {"application/json"})
	public ResponseEntity<?> partialUpdate(@RequestBody Student student) {
		Student st = studentRepo.save(student);
		if(null != st) {
			return ResponseEntity.ok().header("Header01", "Test Header Value").body(st);
		}
		return new ResponseEntity<>("failed to Update",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable long id) { 
		try {
			studentRepo.deleteById(id);
			return ResponseEntity.ok().body("Deleted Successfully");
			
		}
		catch(Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	
}
