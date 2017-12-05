package poc.spring.boot.invoice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import poc.spring.boot.invoice.model.Invoice;
import poc.spring.boot.invoice.service.InvoiceService;

@RestController
public class InvoiceController {

	@Autowired
	InvoiceService invoiceService;

	@RequestMapping(method = RequestMethod.GET, value = "/invoiceById", produces = "application/json")
	public Invoice getInvoiceById(@RequestParam("id") Integer id) {
		return invoiceService.findById(id);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/invoiceByCustomerId", produces = "application/json")
	public List<Invoice> getInvoiceByCustomerId(@RequestParam("customerId") Integer customerId) {
		return invoiceService.findByCustomerId(customerId);
	}

	@RequestMapping("/invoices")
	List<Invoice> findAll() {
		List<Invoice> invoices = invoiceService.findAll();
		return invoices;
	}

}
