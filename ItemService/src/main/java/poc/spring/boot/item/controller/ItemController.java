package poc.spring.boot.item.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import poc.spring.boot.item.model.Item;
import poc.spring.boot.item.service.ItemService;

@RestController
public class ItemController {

	@Autowired
	ItemService itemService;

	@RequestMapping(method = RequestMethod.GET, value = "/itemById", produces = "application/json")
	public Item findById(@RequestParam("id") Integer id) {
		return itemService.findById(id);
	}

	
	@RequestMapping("/itemsByInvoiceId")
	public List<Item> findByInvoiceId(Integer invoiceId) {
		List<Item> items = itemService.findByInvoiceId(invoiceId);
		return items;
	}

	@RequestMapping("/items")
	List<Item> findAllCustomers() {
		List<Item> items = itemService.findAll();
		return items;
	}

}
