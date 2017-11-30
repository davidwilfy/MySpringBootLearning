package demo.mvn.spring.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import demo.mvn.spring.boot.model.Employee;


@Controller    
@RequestMapping(path="/employee") 
public class EmployeeController {

	@GetMapping(path="/get") 
	public @ResponseBody Employee getEmployee() {
		Employee newEmployee = new Employee();
		newEmployee.setFirstName("Dave");
		newEmployee.setLastName("Wilfy");
		newEmployee.setEmail("dw@dw.com");
		return newEmployee;
	}

}
