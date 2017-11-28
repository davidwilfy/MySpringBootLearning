package poc.spring.boot.customer.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import poc.spring.boot.customer.model.Customer;
import poc.spring.boot.customer.rowmapper.CustomerRowMapper;

/**
 * @author 188152
 *
 */
@Repository
public class CustomerDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Transactional(readOnly = true)
	public Customer findById(int id) {
		return jdbcTemplate.queryForObject("select * from customer where ID=?", new Object[] { id },
				new CustomerRowMapper());
	}

	@Transactional(readOnly = true)
	public List<Customer> findAll() {
		return jdbcTemplate.query("select * from customer", new CustomerRowMapper());
	}
	
}
