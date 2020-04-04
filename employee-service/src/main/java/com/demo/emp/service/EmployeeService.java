package com.demo.emp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.emp.domain.Employee;
import com.demo.emp.dto.EmployeeDTO;
import com.demo.emp.mapper.EmployeeMapper;
import com.demo.emp.repo.EmployeeRepo;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepo employeeRepo;
	
	@Autowired
	EmployeeMapper employeeMapper;
	
	
	public List<EmployeeDTO> getEmployeeDetails(){
		List<EmployeeDTO> employeeDTOs = new ArrayList<EmployeeDTO>();
		
		List<Employee> employees = employeeRepo.findAll();
		employeeDTOs = employees.stream().map(employeeMapper::convertToDTO).collect(Collectors.toList());
		return employeeDTOs;
	}
	
	
	public EmployeeDTO getEmployeeById(long empId){
		EmployeeDTO employeeDTO = null;
		
		Optional<Employee> employee = employeeRepo.findById(empId);
		if(employee.isPresent())  {
		employeeDTO = employeeMapper.convertToDTO(employee.get());
		}
		return employeeDTO;
	}
	
	
	@Transactional
	public EmployeeDTO saveEmployee(EmployeeDTO employeeDTO){
		
		Employee employee = employeeMapper.convertToEntity(employeeDTO);
		Employee employee1 = employeeRepo.save(employee);
		if(null != employee1)  {
		employeeDTO = employeeMapper.convertToDTO(employee1);
		}
		return employeeDTO;
	}


	public boolean deleteEmployee(long id) {
		employeeRepo.deleteById(id);
		return true;
	}

}
