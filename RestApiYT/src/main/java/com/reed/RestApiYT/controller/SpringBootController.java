package com.reed.RestApiYT.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.reed.RestApiYT.dao.entities.Employee;
import com.reed.RestApiYT.service.RestApiService;

@RestController
public class SpringBootController {

	@Autowired
	RestApiService restApiService;

	// method to save employee
	@RequestMapping(value = "/employees", method = RequestMethod.POST)
	public Employee save(@RequestBody Employee employee) {
		return restApiService.saveEmployee(employee);

	}

	// method to retrieve employee
	@GetMapping("/employees/{employeeEmail}")
	public Employee retrieveEmployee(@PathVariable("employeeEmail") String empEmail) {
		return restApiService.retrieveEmployee(empEmail);

	}

	// method to update
	// first check employee exist then update
	@RequestMapping(value = "/employeess", method = RequestMethod.POST)
	public Employee Newsave(@RequestBody Employee employee) {

		String emailNewEmployee = employee.getEmployeeEmail();
		Employee employeePersisted = restApiService.retrieveEmployee(emailNewEmployee);
		if (employeePersisted != null) {
			System.out.println("update request");
			employee.setEmployeeId(employeePersisted.getEmployeeId());
			System.out.println("update request");
		} else {
			System.out.println("create request");
		}
		return restApiService.saveEmployee(employee);

	}
	
	//delete employee
	@DeleteMapping("/employees/{employeeEmail}")
	public void deleteEmployee(@PathVariable("employeeEmail") String empEmail) {
		
        restApiService.deleteEmployee(empEmail);
	}

}
