package org.spr.hbr.service;

import java.util.List;

import org.spr.hbr.model.Employee;

public interface EmployeeService {

	Employee findById(int id);
	
	void saveEmployee(Employee employee);
	
	void updateEmployee(Employee employee);
	
	List<Employee> findAllEmployees(); 
		
}
