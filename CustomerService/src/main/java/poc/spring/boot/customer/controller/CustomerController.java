package poc.spring.boot.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import poc.spring.boot.customer.model.Customer;
import poc.spring.boot.customer.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@RequestMapping(method = RequestMethod.GET, value = "/customerById", produces = "application/json")
	public Customer getInvoiceById(@RequestParam("id") Integer id) {
		return customerService.findById(id);
	}

	@RequestMapping("/customers")
	List<Customer> findAllCustomers() {
		List<Customer> invoices = customerService.findAll();
		return invoices;
	}

}
