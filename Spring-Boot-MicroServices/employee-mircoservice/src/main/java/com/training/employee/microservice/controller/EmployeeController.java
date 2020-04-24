package com.training.employee.microservice.controller;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.training.employee.microservice.entity.Department;
import com.training.employee.microservice.entity.Employee;
import com.training.employee.microservice.repo.DepartmentRepo;
import com.training.employee.microservice.repo.EmployeeRepo;
import com.training.employee.microservice.service.EmployeeService;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

	
	 @Autowired 
	 EmployeeRepo employeeRepo;
	 
	 @Autowired 
	 DepartmentRepo departmentRepo;

	
	 private final EmployeeService employeeService;
	 
	 
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}


	@GetMapping("/")
	public String home() {
		System.out.println("inside employee");
		return "home";
	}

	
	@GetMapping("/findAll")
	public Employee[] findAll() {
		
		//List<Employee> employees = employeeRepo.findAll();
		List<Employee> employees = employeeRepo.findByDepartmentDepartmentName("IT");
		//List<Employee> employees = employeeRepo.findBySalaryBetween(5000L,200000L);
		//List<Employee> employees = employeeRepo.findByDepartmentAndName("IT","Raj");
		//List<Employee> employees = employeeRepo.findByNameContainingIgnoreCase("raj");
		Employee[] employees2 = employees.stream().toArray(Employee[]::new);
		return employees2;
	}
	
	@GetMapping("/createEmployee")
	public String loadCreateEmployee(Model model) {
		//List<Employee> employees = employeeRepo.findAll();
		model.addAttribute("employee", new Employee());
		return "create-employee";
	}
	
	
	@PostMapping(value = "/save")
	public String save(@Valid Employee employee, Model model,RedirectAttributes attributes) {
		System.out.println("Employee : "+employee);
		employeeRepo.save(employee);
		attributes.addFlashAttribute("message", "Saved Successfully");
		return "redirect:/employee/findAll";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("empId") Long empId ,RedirectAttributes attributes) {
		employeeRepo.deleteById(empId);
		attributes.addFlashAttribute("message", "Deleted Successfully");
		return "redirect:/employee/findAll";
	}
	
	@GetMapping("/edit")
	public String edit(@RequestParam("empId") Long empId,Model model) {
		Optional<Employee> employee = employeeRepo.findById(empId);
		model.addAttribute("employee", employee.get());
		return "create-employee";
	}
	
	
	@GetMapping("/findAllDepart")
	public String findAllDepartment(Model model) {
		List<Department> departments = departmentRepo.findAll();
		model.addAttribute("departments", departments);
		return "list_department";
		
	}
	

	/*
	 * @GetMapping("/findById/{id}") public Student findAll(@PathVariable long id) {
	 * Optional<Student> student = employeeRepo.findById(id); if
	 * (student.isPresent()) { return student.get(); } else { return null; } }
	 * 
	 * @GetMapping("/getById") public Student findById(@RequestParam(name = "id")
	 * long id) { Optional<Student> student = employeeRepo.findById(id); if
	 * (student.isPresent()) { return student.get(); } else { return null; } }
	 * 
	 * @PostMapping(value = "/save", consumes = { "application/json" }) public
	 * String save(@ModelAttribute Student student, Model model) { // Student st =
	 * studentRepo.save(student);
	 * 
	 * model.addAttribute("Status", "added Successfully"); // if(null != st) { //
	 * return "Saved Successfully"; // } return "Failed To Save"; }
	 */
	/*
	 * @PutMapping(value = "/update", consumes= {"application/json"}) public String
	 * update(@RequestBody Student student) { Student st =
	 * studentRepo.save(student); if(null != st) { return "Update Successfully"; }
	 * return "Failed To Update"; }
	 * 
	 * @DeleteMapping("/delete/{id}") public String delete(@PathVariable long id) {
	 * studentRepo.deleteById(id); return "Deleted Successfully"; }
	 */

}
