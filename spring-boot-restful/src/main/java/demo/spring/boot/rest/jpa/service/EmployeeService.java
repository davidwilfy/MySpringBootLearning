package demo.spring.boot.rest.jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.spring.boot.rest.jpa.entity.Employee;
import demo.spring.boot.rest.jpa.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	public Iterable<Employee> addEmployee(Employee newEmployee) {
		employeeRepository.save(newEmployee);
		return getAllEmployees();
	}

	public Iterable<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

}
