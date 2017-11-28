package poc.spring.boot.item.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import poc.spring.boot.item.model.Item;

/**
 * @author 188152
 *
 */
public class ItemRowMapper implements RowMapper<Item>{

	@Override
    public Item mapRow(ResultSet rs, int rowNum) throws SQLException {
		Item item = new Item();
		item.setId(rs.getInt("id"));
		item.setInvoiceId(rs.getInt("invoiceId"));
		item.setProductId(rs.getInt("productId"));
		item.setQuantity(rs.getInt("quantity"));
        return item;
    }

}
