package poc.spring.boot.invoice.service;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import poc.spring.boot.invoice.dao.InvoiceDao;
import poc.spring.boot.invoice.model.Invoice;
import poc.spring.boot.invoice.model.Item;

@Service
public class InvoiceService {

	@Autowired
	private InvoiceDao invoiceDao;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Value("${itemsByInvoiceIdURI}")
	private String itemsByInvoiceIdURI;
	
	public Invoice findById(int id) {
		Invoice invoice = invoiceDao.findById(id);
		
		invoice.setItems(itemsByInvoiceId(id));
		
		return invoice; 
		
	}
	
	public List<Invoice> findByCustomerId(int customerId) {
		List<Invoice> invoices = invoiceDao.findByCustomerId(customerId);
		
		for(Invoice invoice: invoices) {
			invoice.setItems(itemsByInvoiceId(invoice.getId()));
		}
		return invoices;
	}
	
	private List<Item> itemsByInvoiceId(Integer id) {
		String url = MessageFormat.format(itemsByInvoiceIdURI, id);
		String itemsJSONString = restTemplate.getForObject(url, String.class);
		ObjectMapper mapper = new ObjectMapper();
		List<Item> items = new ArrayList<Item>();
		try {
			TypeReference<List<Item>> mapType = new TypeReference<List<Item>>() {};
			items = mapper.readValue(itemsJSONString, mapType);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return items;
	}

	public List<Invoice> findAll() {
		return invoiceDao.findAll();
	}

}
