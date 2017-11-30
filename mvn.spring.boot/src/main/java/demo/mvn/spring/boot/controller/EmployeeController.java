package demo.mvn.spring.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import demo.mvn.spring.boot.model.Employee;
import demo.mvn.spring.boot.repository.EmployeeRepository;


@Controller    
@RequestMapping(path="/employee") 
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;

	@GetMapping(path="/add") 
	public @ResponseBody Iterable<Employee> addNewEmployee(@RequestParam String firstName, @RequestParam String lastName
			, @RequestParam String email) {
		Employee newEmployee = new Employee();
		newEmployee.setFirstName(firstName);
		newEmployee.setLastName(lastName);
		newEmployee.setEmail(email);
		employeeRepository.save(newEmployee);
		return getAllEmployees();
	}

	@GetMapping(path="/all")
	public @ResponseBody Iterable<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}
}
