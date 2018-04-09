package org.spr.hbr.web;

import java.util.List;

import org.spr.hbr.model.Employee;
import org.spr.hbr.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SampleController {

	@Autowired
	private EmployeeService employeeService;
	
	 @RequestMapping(value="/", method=RequestMethod.GET)
	 public String home(){
		 
		 List<Employee> employeeList = employeeService.findAllEmployees();
		 System.out.println("emp: "+employeeList);
		 return "test";
	 }
 
}