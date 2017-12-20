package demo.spring.boot.rest.jpa.repository;

import org.springframework.data.repository.CrudRepository;

import demo.spring.boot.rest.jpa.entity.Employee;


//This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
//CRUD refers Create, Read, Update, Delete

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

}
