package com.reed.RestApiYT.dao.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Employee {

	@Id
	@GeneratedValue
	private Long employeeId;

	private String employeeName;
	@Column(unique=true,nullable=false)
	private String employeeEmail;
	private String employeeAge;
	
	public Employee(){
		
	}
	
	public Employee(Long employeeId, String employeeName, String employeeEmail, String employeeAge) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeeEmail = employeeEmail;
		this.employeeAge = employeeAge;
	}
	@Override
	public String toString() {
		return String.format("Employee [employeeId=%s, employeeName=%s, employeeEmail=%s, employeeAge=%s]", employeeId,
				employeeName, employeeEmail, employeeAge);
	}
	public Long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmployeeEmail() {
		return employeeEmail;
	}
	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}
	public String getEmployeeAge() {
		return employeeAge;
	}
	public void setEmployeeAge(String employeeAge) {
		this.employeeAge = employeeAge;
	}
}
