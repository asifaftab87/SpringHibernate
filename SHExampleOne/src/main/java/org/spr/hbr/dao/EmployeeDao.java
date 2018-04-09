package org.spr.hbr.dao;

import java.util.List;

import org.spr.hbr.model.Employee;

public interface EmployeeDao {

	Employee findById(int id);

	void saveEmployee(Employee employee);
	
	List<Employee> findAllEmployees();


}
