package controller;

import utility.Reader;

public class AssertionErrorDemo {
		
	public static void main(String [] args) {
		
		int age = Reader.readInt("Enter your age");
		
		assert(age > 17);
		System.out.println(Message.ALLOWED);
		
		displayUsingSimpleOutput(age);
		displayUsingTryCatch(age);
		
	}
	
	public static void displayUsingSimpleOutput(int age) {
		System.out.println("\n\nInside displayUsingSimpleOutput");
		
		if(age > 17) {
			System.out.println(Message.ALLOWED);
		}else {
			System.err.println(Message.NOT_ALLOWED);
		}
	}
	
	
	public static void displayUsingTryCatch(int age){
		System.out.println("\n\nInside displayUsingTryCatch");
		try {
			if(age > 17) {
				System.out.println(Message.ALLOWED);
			}
		}catch(Exception e){
			System.err.println(Message.NOT_ALLOWED);
		}
		
	}
	
	public static void checkUsingAssert(int age) {
		assert(age > 17);
		System.out.println(Message.ALLOWED);
	}
}
