package com.reed.RestApiYT.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reed.RestApiYT.dao.entities.Employee;
import com.reed.RestApiYT.dao.repo.EmployeesRepo;

@Service
public class RestApiService {

	@Autowired
	EmployeesRepo employeesRepo;
	public Employee saveEmployee(Employee employee) {
	return	employeesRepo.save(employee);
	}

	public Employee retrieveEmployee(String empEmail) {
		return employeesRepo.findByEmployeeEmail(empEmail);
	}
	
	public void deleteEmployee(String empEmail) {
		Employee employee= employeesRepo.findByEmployeeEmail(empEmail);
		employeesRepo.delete(employee);
	}
	
	
}
