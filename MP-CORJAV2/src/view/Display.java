package view;

import java.io.IOException;
import java.sql.*;
import java.util.Scanner;

import model.BPI;
import utility.Reader;

public class Display {
	
	public static void header() {
		System.out.println("\t===================================================");
		System.out.println("\t===================================================");
		System.out.println("\t\t  BANK DATABASE MANAGEMENT SYSTEM");
		System.out.println("\t\t\t  Programmed by");
		System.out.println("\t\tJohn Leonard Rada & Enrico San Juan");
		System.out.println("\t===================================================");
		System.out.println("\t===================================================");
		System.out.println("\n");
	
	}
	
	public static void initializeArray(BPI users[]) {

		
		for (int counter = 0; counter < users.length; counter++) {
			users[counter] = new BPI();
		}
	}
	
	public static void option(BPI users ,  ResultSet records) throws ClassNotFoundException, SQLException, IOException, NullPointerException {
		Scanner scan = new Scanner(System.in);
		
		String choice;
		do {
			System.out.println("SELECT A CHOICE:");
			System.out.println("----------------");
		    System.out.print("[C]-Create Account\n");
		    System.out.print("[W]-Withdraw\n");
		    System.out.print("[B]-Balance\n");
		    System.out.print("[L]-List\n");
		    System.out.print("[D]-Delete Record\n");
		    System.out.print("[Q]-Quit\n");
		    System.out.println("\nSELECTION OPTION:");
		    System.out.println("-----------------");
		    
		    choice = scan.nextLine().toUpperCase();
		    
		    switch(choice){

		    case "C":
		    	createAccount();
		    	break;
		    case "W": 
		    	withdraw(users);
		    case "B":
		    	balanceInquiry(users);
		        break;
		    case "L": 
		    	 ResultSet allRecords = new BPI().listRecord();
				 Display.list(allRecords);
		        break;
		    case "D":
		    	delete(users);
		        break;
		    case "Q": 
		    	quit(users);
		         break;
		    default:
		    System.out.println(choice + " is an invalid input! Select another choice.");
		    }
		} while(choice != "Q");
    
		scan.close();
		
	}
		
	
	public static void createAccount() throws IOException, ClassNotFoundException, SQLException {
		
		BPI newAccount = new BPI();
		newAccount.openAccount(Reader.readString("Enter name"), 
							   Reader.readDouble("Enter amount"),
							   Reader.readString("Enter account number"));
	
		insertSQL(newAccount);
	}
	
	public static void insertSQL(BPI customer) throws ClassNotFoundException, SQLException{
		System.out.println((customer.insertRecord())
			?"\nRECORD INSERTED":"\nRECORD NOT INSERTED");
	}
		
	public static void withdraw(BPI users) throws IOException, ClassNotFoundException, SQLException {
		
		
	}
	
	public static void withdrawSQL(BPI customer) throws ClassNotFoundException, SQLException{

	}
	
	public static void balanceInquiry(BPI users) {
		
	}
	
	public static void list(ResultSet records) throws ClassNotFoundException, SQLException{
		
		if (records != null) {
			System.out.println("ID\tAccount Number\t\tName\t\t\tBalance\n");
			while (records.next()) {
				System.out.println(records.getInt("id")+"\t"
					+records.getString("accountNumber")+"\t\t"
					+records.getString("name")+"\t"
					+records.getDouble("balance"));
			}
		} else {
			System.out.println("NO RECORDS.");
		}
	}
	
	public static void delete(BPI users) throws ClassNotFoundException, SQLException {
		BPI newAccount = new BPI();
		newAccount.deleteAccount(Reader.readString("Enter account number"));
		
	}
	
	public static void deleteSQL(BPI customer) throws ClassNotFoundException, SQLException{
		System.out.println((customer.deleteRecord())
				?"\nRECORD DELETED":"\nRECORD NOT DELETED");
	}
	
	public static void quit(BPI users) {
		System.out.println("TERMINATING PROGRAM...");
		timer();
		System.out.println("Program Terminated!");
		System.exit(0); 
	}
	
	public static void timer() {

		try{
		    Thread.sleep(1000);
		}
		catch(InterruptedException ex){
		    Thread.currentThread().interrupt();
		}
		
	}

	
}
