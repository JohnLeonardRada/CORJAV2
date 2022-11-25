package model;

public class Address {

	private String number;
	private String street;
	private String city;
	private String region;
	private int zip;
	
	public Address() {
	
	}

	public Address(String number, String street, String city, String region, int zip) {
		super();
		this.number = number;
		this.street = street;
		this.city = city;
		this.region = region;
		this.zip = zip;
	}

	@Override
	/*
	The toString() is an inherited method from the java.lang.Object
	that needs to be overridden to make it something useful
	 */

	public String toString() {
		return "Address is " + this.number + " " + this.street + " " 
			+ this.city + " " + this.region + " " + this.zip;
	}

}