package poc.spring.boot.product.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import poc.spring.boot.product.model.Product;

@Repository
public class ProductDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Transactional(readOnly = true)
	public Product findById(int id) {
		return jdbcTemplate.queryForObject("select * from PRODUCT where ID=?", new Object[] { id },
				new ProductRowMapper());
	}

	@Transactional(readOnly = true)
	public List<Product> findAll() {
		return jdbcTemplate.query("select * from PRODUCT", new ProductRowMapper());
	}

}
