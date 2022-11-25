package controller;

import model.*;

public class DemoAggregateStrongRelationship {

	public static void main(String[] args) {

		Employee emp = new Employee("Dwayne Wade", new Address("123", "ABC Street", "Makati City", "NCR", 1100));
		System.out.println(emp);
		System.out.println("\n\nonly address: " + emp.getAddress());

		//Destroy the emp object
		//Is now a candidate to be garbage collected by the JVM
		emp = null;
		System.out.println("\n\nonly address: " + emp.getAddress());

		//object resurrection
		emp = new Employee("Dwayne Wade", new Address("123", "ABC Street", "Makati City", "NCR", 1100));
		System.out.println("\n\nonly address: " + emp.getAddress());

	}

}