package model;

public class Employee {
	
	private String name;
	private Address address; //HAS-A Aggregate Strong Relationship

	public Employee() {

	}

	public Employee(String name, Address address) {
		this.name = name;
		this.address = address;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Name: " + this.name + "\n" + address;
	}

}