package controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.sql.SQLException;

import view.Display;
import model.CustomerBean;

public class MPController extends Display {
	
	
	public static void main(String args[]) throws IOException, ClassNotFoundException, SQLException{
		
		PrintStream console = new PrintStream(new File("logfile.txt"));
		
		CustomerBean cb = new CustomerBean();
		printFile();
		cb.createTable();
		
		cb.readFile();
		System.out.println("\nXML Created!");
		System.out.println("\nApplication terminated");
		
		System.setOut(console);
		cb.printRecords();

	}
}
	


