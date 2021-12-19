package com.reed.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.reed.dao.entities.Employee;
import com.reed.service.RestApiService;

@RestController
public class SpringBootController {

	@Autowired
	RestApiService restApiService;

	@RequestMapping(value = "/employees", method = RequestMethod.POST)
	public Employee save(@RequestBody Employee employee) {

		String emailNewEmployee = employee.getEmployeeEmail();
		Employee employeePersisted = restApiService.retrieveEmployee(emailNewEmployee);
		if (employeePersisted != null) {
			System.out.println("It is an update request");
			employee.setEmployeeID(employeePersisted.getEmployeeID());
			return restApiService.saveEmployee(employee);

		} else {
			System.out.println("It is a create request");
			return restApiService.saveEmployee(employee);
		}

	}

	@GetMapping("/employees/{employeeEmail}")
	public Employee retrieveEmployee(@PathVariable("employeeEmail") String empEmail) {
		return restApiService.retrieveEmployee(empEmail);
	}
	
	@DeleteMapping("/employees/{employeeEmail}")
	public void deleteEmployee(@PathVariable("employeeEmail") String empEmail) {
		restApiService.deleteEmployee(empEmail);
	}

}
