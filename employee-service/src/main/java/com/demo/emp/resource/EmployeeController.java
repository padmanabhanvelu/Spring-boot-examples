package com.demo.emp.resource;


import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.demo.emp.dto.EmployeeDTO;
import com.demo.emp.service.EmployeeService;

/**
 * Rest api controller for inventory adjustment 
 * 
 * @author gssrakar
 *
 */

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {
  
 private Log logger  = LogFactory.getLog(EmployeeController.class);

 private final EmployeeService employeeService;
 
 
 	public EmployeeController(EmployeeService employeeService) {
 		this.employeeService = employeeService;
 	}
 
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String healthCheck() {
		logger.info("Working!");
		return "Home...";

	}

	@RequestMapping(value = "/getAll", method = RequestMethod.GET)
	public List<EmployeeDTO> getAllEmployees() {
		logger.info("get All employees Initiated");
		
		return employeeService.getEmployeeDetails();

	}
	
	@RequestMapping(value = "/getById/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getEmployee(@PathVariable("id") long id) {
		logger.info("get employee by id initiated");
		EmployeeDTO dto = employeeService.getEmployeeById(id);
		if(null != dto)
			return ResponseEntity.ok(dto);
		else
			return ResponseEntity.notFound().build();
	}
	
	
	
	@PostMapping(value = "/save", consumes= {"application/json"}, produces = { "application/json" })
	@ResponseStatus(HttpStatus.CREATED)
	public EmployeeDTO saveEmployee(@RequestBody EmployeeDTO employeeDTO) {
		logger.info("save employee initiated");
		return employeeService.saveEmployee(employeeDTO);
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public ResponseEntity<?> deleteEmployee(@PathVariable("id") long id) {
		logger.info("Delete employee initiated");
		employeeService.deleteEmployee(id);
		return ResponseEntity.ok("Deleted Succcessfully");
	}
  
	

}