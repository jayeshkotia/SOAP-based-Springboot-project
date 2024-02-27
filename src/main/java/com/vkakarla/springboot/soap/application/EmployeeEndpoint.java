package com.vkakarla.springboot.soap.application;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.vkakarla.springboot.soap.entities.Employee;
import com.vkakarla.springboot.soap.interfaces.AddEmployeeRequest;
import com.vkakarla.springboot.soap.interfaces.AddEmployeeResponse;
import com.vkakarla.springboot.soap.interfaces.ServiceStatus;
import com.vkakarla.springboot.soap.serviceImpl.EmployeeService;


@Endpoint
public class EmployeeEndpoint {
	
	private static final String NAMESPACE_URI = "http://interfaces.soap.springboot.vkakarla.com";

	@Autowired
	private EmployeeService employeeService;


	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "addEmployeeRequest")
	@ResponsePayload
	public AddEmployeeResponse addEmployee(@RequestPayload AddEmployeeRequest request) {
		AddEmployeeResponse response = new AddEmployeeResponse();
		ServiceStatus serviceStatus = new ServiceStatus();

		Employee employee = new Employee();
		BeanUtils.copyProperties(request.getEmployeeInfo(), employee);
		employeeService.AddEmployee(employee);
		serviceStatus.setStatus("SUCCESS");
 	    serviceStatus.setMessage("Content Added Successfully");
		response.setServiceStatus(serviceStatus);
		return response;
	}
}
