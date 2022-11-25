package utility;

import java.io.*;

public class Reader {
	private static BufferedReader getReader() {
		return new BufferedReader(new InputStreamReader(System.in));
	}
	
	public static String readString(String message) {
		String input = null;
		try {
			System.out.print(message + ": ");
			input = getReader().readLine();
		} catch (IOException ioe) {
			System.err.println(ioe.getMessage());
		}
		return input; 
	}
	
	public static int readInt(String message){
		System.out.print(message+ ": ");
		
		int input = 0; 
		try {
			input = Integer.parseInt(getReader().readLine());
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return input;
	}
	
	public static double readDouble(String message) throws IOException {
		System.out.print(message+ ": ");
		
		//the method Integer.parseInt() converts a String value 
		//to a double primitive value
		return Double.parseDouble(getReader().readLine());
	}
}
