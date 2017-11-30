package demo.mvn.spring.boot.repository;

import org.springframework.data.repository.CrudRepository;

import demo.mvn.spring.boot.model.Employee;


//This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
//CRUD refers Create, Read, Update, Delete

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

}
