package poc.spring.boot.invoice.model;

public class Product {

	private Integer id;
    private String name;
    private double price;
    
    
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}




	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}




	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}




	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}




	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}




	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}




	@Override
	public String toString() {
		return "Invoice [ID=" + id + ", name=" + name + ", price=" + price + "]";
	}

}
