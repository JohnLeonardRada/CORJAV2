package controller;

import java.io.FileInputStream;
import java.io.IOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;


import model.*;
import view.*;

import utility.Reader;


public class MainClass extends CustomerBean{

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		List<CustomerBean> cbean = new ArrayList<CustomerBean>();
		List<CustomerBean> invalidEntries = new ArrayList<CustomerBean>();
		CustomerBean customer = new CustomerBean();
		
		
		
		//create table upon execution of the program
		customer.createTable();
		
		//asks the user to read the file desired
		String fileName = Reader.readString("What is the name of the file to read from?");
		System.out.println("\nNow reading from " + fileName + " ...." + "\n");
		
		try {
			//Initialize Scanner function
			FileInputStream fis = new FileInputStream(fileName);
//			FileOutputStream fos = new FileOutputStream(fileName);
			Scanner sc = new Scanner(fis);
			
			//loop for scanning entries
			do {	
			     try {	
			    	 
			    	//scans the entries inside the file 
			        sc.useDelimiter("\n");
			        
			        //scans the customer name
			        System.out.println("\n");
					customer.setCustomerName(sc.nextLine());
					System.out.println("Customer Name: " + customer.getCustomerName());
					customer.assertCustomerName();
					
					//scans the customer's credit card number
					customer.setCcNumber(sc.nextLine());
					System.out.println("CC Number: " + customer.getCcNumber());
					customer.assertCCNumber();
					
					//scans the product name of the customer
					customer.setProductName(sc.nextLine());
					System.out.println("Product Name: " + customer.getPb().getProductName());
					customer.assertProductName();
					
					//scans the product price of the customer
					customer.setProductPrice(Double.parseDouble((sc.nextLine())));
					System.out.println(("Product Price: " + customer.getPb().getPrice()));	
					customer.assertProductPrice();
					
					for(CustomerBean cb: cbean) {
						try {
							//create log file for each entries
							Display.createLogFile(customer.getCustomerName());
							Display.createLogFile(customer.getCcNumber());
							Display.createLogFile(customer.getPb().getProductName());
//							Display.createLogFile(customer.getPb().getPrice());
							
							while(Display.isValid(cb.getCcNumber())&& Display.luhnTest(cb.getCcNumber()) && Display.priceChecker(cb.getPb().getPrice()) == !false){
								//insert record on database
								cb.insertRecord();
								System.out.println("Records successfully inserted!");
							}
							//check all exceptions
							//list of unsuccessful entries
						}catch(InvalidCreditCardNumberLength iccnl) {
							iccnl.getMessage();
							invalidEntries.add(cb);
							Reader.createXMLDatabaseFile(cb);
						}catch(LuhnFailedAlgorithmException lfae) {
							lfae.getMessage();
							invalidEntries.add(cb);
							Reader.createXMLDatabaseFile(cb);
						}
					}
			
					//string collections
					System.out.println(customer.getCustomerName());
					System.out.println(customer.getCcNumber());
					System.out.println(customer.getPb().getProductName());
					System.out.println(customer.getPb().getPrice());
					
					
					
			     } catch (Exception e) {		    	 
			    	 System.out.println(e.getMessage());
			     } 
			     
			} while (sc.hasNextLine()); //will end if no entries can be scanned
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
}
	

