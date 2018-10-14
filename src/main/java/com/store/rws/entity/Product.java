package com.store.rws.entity;

/**
 * Product entity class which represents each item and it's attributes
 * 
 * @author Sreejith
 *
 */
public class Product {
	public enum ProductCategory {GROCERY, OTHER};
	private Integer id;
	private String name;
	private String category; // grocery/ other
	private double price;
	private Integer quantity = 1;
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	//write the code for the equals method
	//return true;
	public boolean equals(Product product) {
		
		boolean result = false;
		if (this.name.equalsIgnoreCase(product.getName()) && this.price == product.getPrice())
			result = true;
		else
			result = false;
 
		return result;
	}
 
	public String toString() {			
		String result="";	 
		return result;
	}
}

