package poc.spring.boot.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import poc.spring.boot.product.model.Product;
import poc.spring.boot.product.service.ProductService;

/**
 * @author 188152
 *
 */
@RestController
public class ProductController {

	@Autowired
	ProductService productService; 

	@RequestMapping(method = RequestMethod.GET, value = "/productById", produces = "application/json")
	public Product getProductById(@RequestParam("id") Integer id) {
		return productService.findById(id);
	}

	@RequestMapping("/products")
	List<Product> findAllProducts() {
		List<Product> products = productService.findAll();
		return products;
	}

}
