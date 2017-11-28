package poc.spring.boot.invoice.model;

import java.util.List;

/**
 * @author 188152
 *
 */
public class Invoice {

	private Integer id;
	private Integer customerId;
	private String invoiceDate;
	private List<Item> items;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}



	/**
	 * @return the invoiceDate
	 */
	public String getInvoiceDate() {
		return invoiceDate;
	}



	/**
	 * @param invoiceDate the invoiceDate to set
	 */
	public void setInvoiceDate(String invoiceDate) {
		this.invoiceDate = invoiceDate;
	}



	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}



	/**
	 * @return the customerId
	 */
	public Integer getCustomerId() {
		return customerId;
	}



	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}


	/**
	 * @return the items
	 */
	public List<Item> getItems() {
		return items;
	}



	/**
	 * @param items the items to set
	 */
	public void setItems(List<Item> items) {
		this.items = items;
	}



	@Override
	public String toString() {
		return "Invoice [ID=" + id + ", customerID=" + customerId + ", invoiceDate=" + invoiceDate + "]";
	}

}
