package model;

public class Child extends Parent {
	//public String clazz = getClass().getName();
	
	@Override
	public void message() {
		clazz = getClass().getName();
		System.out.println("A new message from the " + clazz);
	}
}
