package org.spr.hbr.web;

import java.util.ArrayList;
import java.util.List;

import org.dozer.Mapper;
import org.spr.hbr.form.EmployeeForm;
import org.spr.hbr.model.Employee;
import org.spr.hbr.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleRestController {

	@Autowired
	private Mapper dozerMapper;
	
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping(value="/getAllEmployee", method = RequestMethod.GET, produces = "application/json")
	public List<EmployeeForm> getList(){
		
		List<Employee> employeeList = employeeService.findAllEmployees();
		List<EmployeeForm> employeeFormList = new ArrayList<EmployeeForm>();
		
		for(Employee employee : employeeList){
			EmployeeForm employeeForm = dozerMapper.map(employee, EmployeeForm.class);
			employeeFormList.add(employeeForm);
		}
		
		return employeeFormList;
	}
}
