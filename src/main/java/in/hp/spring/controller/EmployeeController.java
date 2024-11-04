package in.hp.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.hp.spring.entity.Employee;
import in.hp.spring.service.EmployeeService;

@Controller


public class EmployeeController {

	
	@Autowired
	private EmployeeService service;
	
//	METHOD TO DISPLAY LIST OF EMPLOYEES
	@GetMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("listOfEmployees",service.getAllEmployees());
		return "index";
	}
	
	@GetMapping("/showNewEmployeeForm")
	public String showNewEmployeeForm(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "new_employee";
	}
	
	@PostMapping("/saveEmployee")
	public String saveEmployee(
			@ModelAttribute("employee") Employee employee) {
		service.saveEmployee(employee);
		return "redirect:/";
	}
	
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(
			@PathVariable (value = "id") long id, Model model) {
		
//		get Employee from the Service
		
		Employee employee = service.getEmployeeById(id);
		
//		Set Employee as Attribute to pre-populate the form
		
		model.addAttribute("employee", employee);
		
		return "updated_employee";
	}
}
