package poc.spring.boot.invoice.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.springframework.jdbc.core.RowMapper;

import poc.spring.boot.invoice.model.Invoice;

/**
 * @author 188152
 *
 */
public class InvoiceRowMapper implements RowMapper<Invoice>{

	@Override
    public Invoice mapRow(ResultSet rs, int rowNum) throws SQLException {
		Invoice invoice = new Invoice();
		invoice.setId(rs.getInt("id"));
		invoice.setCustomerId(rs.getInt("customerId"));
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		String invoiceDate = df.format(rs.getDate("invoiceDate"));
		invoice.setInvoiceDate(invoiceDate);
        return invoice;
    }

}
