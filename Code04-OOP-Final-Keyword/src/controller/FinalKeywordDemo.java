package controller;

import model.*;
public class FinalKeywordDemo {
	
	public static void main(String args []) {
		
		Child obj = new Child();
		
		String name = "Leonard";
		
		final String gender = "Male";
		final boolean isMale = true;
		
		//gender = "Female";
		
		//Blank Final
		final String courseToTake;
		
		courseToTake = "Bachelor of Science in CS with Specialization in SE";
		
		obj.message();
		System.out.println(courseToTake);
		
		//Illegal assigning of value as the final variable already contains a value.
		//courseToTake = "BS in Game Development";
		
			
		
	}
}
