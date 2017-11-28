package poc.spring.boot.customer.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import poc.spring.boot.customer.dao.CustomerDao;
import poc.spring.boot.customer.model.Customer;
import poc.spring.boot.customer.model.Invoice;

/**
 * @author 188152
 *
 */
@Service
public class CustomerService {

	@Autowired
	private CustomerDao customerDao;
	
	@Autowired
	RestTemplate restTemplate;
	
	public Customer findById(int id) {
		
		String invoiceJSONString = restTemplate.getForObject("http://localhost:8090/invoice/invoiceByCustomerId?customerId="+id, String.class);
		ObjectMapper mapper = new ObjectMapper();
		List<Invoice> invoices = new ArrayList<Invoice>();
		try {
			TypeReference<List<Invoice>> mapType = new TypeReference<List<Invoice>>() {};
			invoices = mapper.readValue(invoiceJSONString, mapType);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Customer customer = customerDao.findById(id);
		customer.setInvoices(invoices);
		
		return customer; 
	}

	public List<Customer> findAll() {
		return customerDao.findAll();
	} 

}
