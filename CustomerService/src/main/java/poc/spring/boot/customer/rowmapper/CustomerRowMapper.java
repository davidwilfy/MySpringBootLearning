package poc.spring.boot.customer.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import poc.spring.boot.customer.model.Customer;

public class CustomerRowMapper implements RowMapper<Customer>{

	@Override
    public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
		Customer customer = new Customer();
		customer.setId(rs.getInt("id"));
		customer.setFirstName(rs.getString("firstName"));
		customer.setLastName(rs.getString("lastName"));
        return customer;
    }

}
