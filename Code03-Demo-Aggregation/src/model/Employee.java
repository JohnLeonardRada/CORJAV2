package model;

//that an Employee HAS-A inner Address class

public class Employee { //outer class

	private String name;

	public Employee() {
	}

	public Employee(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

//HAS-A Relationship

public class Address { //is an inner class

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

	/*if (this.zip == 1607) {
		class ZipCodeMessage {
			String message = "Address is on Pasig City";
		public void displayZipMessage() {
			System.out.println(message);
		}
	
	}
	new ZipCodeMessage().displayZipMessage();

	}else if (this.zip == 1006) {
		class ZipCodeMessage {
			String message = "Address is on Binondo, Manila";
		public void displayZipMessage() {
			System.out.println(message);	
		}
		
	}
	new ZipCodeMessage().displayZipMessage();

	}else if (this.zip == 1015) {
		class ZipCodeMessage {
			String message = "Address is on Paranuaque City";
		public void displayZipMessage() {
			System.out.println(message);
		}

	}
	new ZipCodeMessage().displayZipMessage();
	
	}else {
		class ZipCodeMessage {
			String message = "Address is on Makati City";
		public void displayZipMessage() {
			System.out.println(message);
		}

	}
	new ZipCodeMessage().displayZipMessage();

	}*/

		switch (this.zip) {

			case 1607:
			class ZipCodeMessage {
				String messsage = "Address is on Pasig City";
			public void displayZipMessage() {
				System.out.println(messsage);
			}
		}
		new ZipCodeMessage().displayZipMessage();
		break;
		
			case 1006:
			
			class ZipCodeMessage {
				String messsage = "Address is on Binondo, Manila";
			public void displayZipMessage() {
				System.out.println(messsage);
			}
		}
		new ZipCodeMessage().displayZipMessage();
		break;

			case 1015:
			class ZipCodeMessage {
				String messsage = "Address is on Paranuaque City";
			public void displayZipMessage() {
				System.out.println(messsage);
			}
		}	
		new ZipCodeMessage().displayZipMessage();		
		break;

			default:

				class ZipCodeMessage {
					String messsage = "Address is on Makati City";
				public void displayZipMessage() {
					System.out.println(messsage);
					}
				}
				new ZipCodeMessage().displayZipMessage();
				}
				return "Address is " + this.number + " " + this.street + " " + this.city + " " + this.region + " " + this.zip;
				}
				
			}

	@Override
	public String toString() {
		return "Name: " + this.name;
		}

	}