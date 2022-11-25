package generics.controller;

import generics.model.GenericClass;
import generics.model.Person;

public class GenericClassDemo {

	public static void main(String[] args) {
		//using Generic Class as type java.lang.String class
		System.out.println(method("Welcome to iACADEMY"));
		
		//using Generic Class as type java.lang.Integer class
		System.out.println(method(2002));
		
		//using Generic Class as type java.lang.Person class
		Person person = method();
		System.out.println(person.name);
		
		
		
	}
	
	
	
	public static String method(String input){
		//GenericClass <String> gc = new GenericClass<string>(input);
		//return gc.getData();
		return new GenericClass<String>(input).getData();
	}
	
	public static Integer method(int input){
		//GenericClass <Integer> gc = new GenericClass<Integer>(input);
		//return gc.getData();
		return new GenericClass<Integer>(input).getData();
	}
	
	public static Person method(){
		//Person person = new Person;
		//GenericClass <Person> gc = new GenericClass<Person>(person);
		//return gc.getData();
		return new GenericClass<Person>(new Person()).getData();
	}

}
