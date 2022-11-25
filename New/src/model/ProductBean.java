package model;

public class ProductBean {
	
	String productName;
	double price;
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public ProductBean(String productName, double price) {
		this.productName = productName;
		this.price = price;
	}
	
	public ProductBean() {
		
	}
	
}
