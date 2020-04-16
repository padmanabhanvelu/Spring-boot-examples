package com.demo.emp.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.emp.domain.Employee;
import com.demo.emp.dto.EmployeeDTO;

@Component
public class EmployeeMapper {

	@Autowired
	private ModelMapper mapper;

	public EmployeeDTO convertToDTO(Employee employee) {
		return mapper.map(employee, EmployeeDTO.class);
	}

	public Employee convertToEntity(EmployeeDTO employeeDTO) {
		return mapper.map(employeeDTO, Employee.class);
	}
}
