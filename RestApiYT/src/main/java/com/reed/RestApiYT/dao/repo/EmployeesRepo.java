package com.reed.RestApiYT.dao.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.reed.RestApiYT.dao.entities.Employee;
@Repository
public interface EmployeesRepo extends CrudRepository<Employee, Long> {

	public Employee findByEmployeeEmail(String email);


}
