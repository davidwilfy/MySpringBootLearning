package poc.spring.boot.item.model;

public class Item {

	private Integer id;
	private Integer invoiceId;
	private Integer productId;
	private Integer quantity;
	private Product product;

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
	 * @return the invoiceId
	 */
	public Integer getInvoiceId() {
		return invoiceId;
	}

	/**
	 * @param invoiceId the invoiceId to set
	 */
	public void setInvoiceId(Integer invoiceId) {
		this.invoiceId = invoiceId;
	}

	/**
	 * @return the productId
	 */
	public Integer getProductId() {
		return productId;
	}

	/**
	 * @param productId the productId to set
	 */
	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	/**
	 * @return the quantity
	 */
	public Integer getQuantity() {
		return quantity;
	}

	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	
	/**
	 * @return the product
	 */
	public Product getProduct() {
		return product;
	}

	/**
	 * @param product the product to set
	 */
	public void setProduct(Product product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "Item [ID=" + id + ", invoiceId=" + invoiceId + ", quantity=" + quantity + ", productId=" + productId + "]";
	}
	
	/*
	@Override
	   public String toString() {
	     return new ToStringBuilder(this).
	       append("id", id).
	       append("invoiceId", id).
	       append("productId", productId).
	       append("quantity", quantity).
	       toString();
	   }
     */ 
}
