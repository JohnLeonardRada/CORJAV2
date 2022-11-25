package demo.exception;

import java.io.*;

public class ExceptionDemo {

	public static void main(String [] args) throws IOException{
		try{
			String inputNumber = getString("Enter your age: ");
			int number = Integer.parseInt(inputNumber);
			
			//int numberArr[] = new int[-2];
		
			System.out.println("Your current age is " + inputNumber);
			System.out.println("Your age after 5 years is " + (number + 5));

		}finally{
			System.out.println("Application execution termination");
		}
	}
	
	public static String getString(String message) throws IOException{
		BufferedReader reader = new BufferedReader(
			new InputStreamReader(System.in));
			
		System.out.print(message);
		return reader.readLine();
		
	}
}
