package com.student.studentsample.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.student.studentsample.entity.Employee;
import com.student.studentsample.repo.EmployeeRepo;
import com.student.studentsample.util.Utility;

@Controller
@RequestMapping(value = "/employee")
public class EmployeeController {

	
	 @Autowired 
	 EmployeeRepo employeeRepo;

	 @Autowired
	 Utility utility;

	@GetMapping("/")
	public String home() {
		System.out.println("inside employee");
		return "home";
	}

	
	@GetMapping("/findAll")
	public String findAll(Model model) {
		List<Employee> employees = employeeRepo.findAll();
		model.addAttribute("employees", employees);
		return "list_employee";
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
