package controller;

import model.Employee;

public class DemoAggregateStrongRelationship {

public static void main(String[] args) {

	Employee emp = new Employee("Dwayne Wade");
	Employee.Address address = new Employee("Dwayne Wade").new Address("123", "ABC Street","Makati City", "NCR", 1607);

	System.out.println(emp);
	System.out.println(address);

	//Destroy the emp object
	//Is now a candidate to be garbage collected by the JVM
	emp = null;
	System.out.println("\n\nonly address: " + address);

	//Object Resurrection
	/*emp = new Employee("Dwayne Wade", new Address("123", "ABC Street","Makati City", "NCR", 1100));
	System.out.println("\n\nonly address: " + emp.getAddress());*/

	}

}