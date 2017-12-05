package poc.spring.boot.customer.model;

import java.util.List;

public class Customer {

	private Integer id;
	private String firstName;
	private String lastName;
	private List<Invoice> invoices;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the invoices
	 */
	public List<Invoice> getInvoices() {
		return invoices;
	}

	/**
	 * @param invoices the invoices to set
	 */
	public void setInvoices(List<Invoice> invoices) {
		this.invoices = invoices;
	}
	
	/**
	 * @param invoice the invoice to add
	 */
	public void addInvoice(Invoice invoice) {
		this.invoices.add(invoice);
	}
	

	@Override
	public String toString() {
		return "Customer [ID=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}

}
