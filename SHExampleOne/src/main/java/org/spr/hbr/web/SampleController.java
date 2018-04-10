package org.spr.hbr.web;

import java.util.List;

import org.dozer.Mapper;
import org.spr.hbr.form.EmployeeForm;
import org.spr.hbr.model.Employee;
import org.spr.hbr.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class SampleController {

	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private Mapper dozerMapper;
	
	 @RequestMapping(value="/", method=RequestMethod.GET)
	 public String view(@ModelAttribute("employeeForm") EmployeeForm employeeForm, Model model){
		 
		 List<Employee> employeeList = employeeService.findAllEmployees();
		 System.out.println("emp: "+employeeList);
		 
		 if(employeeList!=null && !employeeList.isEmpty()){
			 employeeForm = dozerMapper.map(employeeList.get(0), EmployeeForm.class);
		 }
		 
		 model.addAttribute("id", employeeForm.getId());
		 model.addAttribute("name", employeeForm.getName());
		 model.addAttribute("salary", employeeForm.getSalary());
		 
		 return "redirect:/three";
	 }
 
	 @RequestMapping(value="/two/{username}", method=RequestMethod.GET)
	 public String viewTwo(@PathVariable("username") String username, @ModelAttribute("employeeForm") EmployeeForm employeeForm, Model model){
		 return "test";
	 }
	 
	 @RequestMapping(value="/three", method=RequestMethod.GET)
	 public String viewThree(@ModelAttribute("employeeForm") EmployeeForm employeeForm, Model model){
		 return "test";
	 }
	 
	 @RequestMapping(value="/flashExample", method=RequestMethod.GET)
	 public String flashExample(@ModelAttribute("employeeForm") EmployeeForm employeeForm, RedirectAttributes model){
		 
		 List<Employee> employeeList = employeeService.findAllEmployees();
		 if(employeeList!=null && !employeeList.isEmpty()){
			 employeeForm = dozerMapper.map(employeeList.get(0), EmployeeForm.class);
		 }
		 model.addFlashAttribute("employeeForm", employeeForm);
		 return "redirect:/four";
	 }
	 
	 @RequestMapping(value="/four", method=RequestMethod.GET)
	 public String viewFour(@ModelAttribute("employeeForm") EmployeeForm employeeForm, Model model){
		 System.out.println(model.containsAttribute("employeeForm"));
		 return "test";
	 }
	 
	 @RequestMapping(value="/flashExampleTwo", method=RequestMethod.GET)
	 public ModelAndView flashExampleMAV(@ModelAttribute("employeeForm") EmployeeForm employeeForm, RedirectAttributes model){
		 
		 ModelAndView mav = new ModelAndView();
		 
		 List<Employee> employeeList = employeeService.findAllEmployees();
		 if(employeeList!=null && !employeeList.isEmpty()){
			 employeeForm = dozerMapper.map(employeeList.get(0), EmployeeForm.class);
		 }
		 model.addFlashAttribute("employeeForm", employeeForm);
		 //mav.setViewName("test");
		 mav.setViewName("redirect:/five");
		 //mav.addAllObjects(modelMap)
		 //return "redirect:/four";
		 return mav;
	 }
	 
	 @RequestMapping(value="/five", method=RequestMethod.GET)
	 public String viewFive(@ModelAttribute("employeeForm") EmployeeForm employeeForm, Model model){
		 System.out.println(model.containsAttribute("employeeForm"));
		 return "test";
	 }
}