package demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import utility.Reader;

public class FileInputReadingDemo {
	
	public static void main(String [] args) {
		
		String filename = Reader.readString("What is the name of the file to read from?");
		
		System.out.println("\nNow reading from " + "fileName....\n");
		
		try {
			FileInputStream fis = new FileInputStream(filename);
			
			char data;
			int temp;
			
			do {
				//read one byte at a time the source input file
				temp = fis.read();
				
				data = (char) temp;
				
				if(temp != -1) {
					System.out.print(data);
				}
			} while (temp != -1);
			
			//best practice is to close an open file
			fis.close();
			
		} catch(FileNotFoundException fnfe) {
			System.out.println(fnfe.getMessage());
		} catch(IOException ioe) {
			System.out.println(ioe.getMessage());
		}
		
		System.out.println("\nApplication terminated.");
	}
}
