package com.vkakarla.springboot.soap.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vkakarla.springboot.soap.entities.Employee;
import com.vkakarla.springboot.soap.repo.EmployeeRepository;
import com.vkakarla.springboot.soap.service.IEmployeeService;

@Service
public class EmployeeService implements IEmployeeService{
	
	@Autowired
	 EmployeeRepository employeeRepository;

	@Override
	public void AddEmployee(Employee employee) {
		
		employeeRepository.save(employee);
		
	}

}
