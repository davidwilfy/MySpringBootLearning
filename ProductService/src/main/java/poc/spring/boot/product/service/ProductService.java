package poc.spring.boot.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poc.spring.boot.product.dao.ProductDao;
import poc.spring.boot.product.model.Product;

/**
 * @author 188152
 *
 */
@Service
public class ProductService {

	@Autowired
	private ProductDao productDao;
	
	public Product findById(int id) {
		return productDao.findById(id);
	}

	public List<Product> findAll() {
		return productDao.findAll();
	}

}
