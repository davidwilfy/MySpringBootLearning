package demo.spring.boot.rest.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import demo.spring.boot.rest.jpa.entity.Employee;
import demo.spring.boot.rest.jpa.service.EmployeeService;

@Controller    
@RequestMapping(path="/employee") 
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping(path="/add") 
	public @ResponseBody Iterable<Employee> addEmployee(@RequestParam String firstName, @RequestParam String lastName
			, @RequestParam String email) {
		Employee newEmployee = new Employee();
		newEmployee.setFirstName(firstName);
		newEmployee.setLastName(lastName);
		newEmployee.setEmail(email);
		employeeService.addEmployee(newEmployee);
		return getAllEmployees();
	}

	@GetMapping(path="/all")
	public @ResponseBody Iterable<Employee> getAllEmployees() {
		return employeeService.getAllEmployees();
	}
}
