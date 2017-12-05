package poc.spring.boot.item.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import poc.spring.boot.item.model.Item;
import poc.spring.boot.item.rowmapper.ItemRowMapper;

@Repository
public class ItemDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Transactional(readOnly = true)
	public Item findById(int id) {
		return jdbcTemplate.queryForObject("select * from ITEM where ID=?", new Object[] { id },
				new ItemRowMapper());
	}

	@Transactional(readOnly = true)
	public List<Item> findByInvoiceId(int invoiceId) {
		return jdbcTemplate.query("select * from ITEM where invoiceId=?", new ItemRowMapper(), invoiceId);
	}
	
	@Transactional(readOnly = true)
	public List<Item> findByProductId(int productId) {
		return jdbcTemplate.query("select * from ITEM where productId=?", new ItemRowMapper(), productId);
	}

	@Transactional(readOnly = true)
	public List<Item> findAll() {
		return jdbcTemplate.query("select * from ITEm", new ItemRowMapper());
	}

}
