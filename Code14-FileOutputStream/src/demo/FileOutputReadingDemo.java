package demo;

import java.io.*;

import utility.Reader;

public class FileOutputReadingDemo {
	
	public static void main(String [] args) {
		
		String filename = Reader.readString("What is the name of the file to write to?");
		
		System.out.println("Enter data to " + filename + ". Press q$ to terminate data entry.");
		
		try {
			FileOutputStream fos = new FileOutputStream(filename);
			
			int data;
			
			BufferedReader reader = Reader.getReader();
			boolean isDone = false;
			
			do {
				data = reader.read();
				
				//test if data retrieved is q
				if((char) data == 'q') {
					data = reader.read();
					
					if((char) data == '$') {
						isDone = true;
					}else {
						fos.write('q');
						fos.write(data);
						
					}
						
				}else {
					fos.write(data);
				}
						
			} while (!isDone);
			//best practice is to close an open file
			fos.close();
			
		} catch(FileNotFoundException fnfe) {
			System.out.println(fnfe.getMessage());
		} catch(IOException ioe) {
			System.out.println(ioe.getMessage());
		}
		
		System.out.println("\nApplication terminated.");
	}
}
