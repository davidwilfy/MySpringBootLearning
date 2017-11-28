package poc.spring.boot.invoice.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import poc.spring.boot.invoice.model.Invoice;
import poc.spring.boot.invoice.rowmapper.InvoiceRowMapper;

/**
 * @author 188152
 *
 */
@Repository
public class InvoiceDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Transactional(readOnly = true)
	public Invoice findById(int id) {
		return jdbcTemplate.queryForObject("select * from INVOICE where ID=?", new Object[] { id },
				new InvoiceRowMapper());
	}

	@Transactional(readOnly = true)
	public List<Invoice> findByCustomerId(int customerId) {
		return jdbcTemplate.query("select * from INVOICE where customerId=?", new InvoiceRowMapper(), customerId);
	}

	@Transactional(readOnly = true)
	public List<Invoice> findAll() {
		return jdbcTemplate.query("select * from invoice", new InvoiceRowMapper());
	}

}
