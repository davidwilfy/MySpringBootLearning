package poc.spring.boot.product.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import poc.spring.boot.product.model.Product;

public class ProductRowMapper implements RowMapper<Product>{

	@Override
    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
		Product product = new Product();
		product.setId(rs.getInt("id"));
		product.setName(rs.getString("name"));
		product.setPrice(rs.getFloat("price"));
        return product;
    }

}
