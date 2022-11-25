package controller;

import java.sql.*;

import model.*;
import view.*;

public class AbstractDemo extends BPI{

	public static void main(String[] args) throws ClassNotFoundException, SQLException{
		 /*BPI altheoAccount = new BPI();
		 
		 altheoAccount.openAccount("Altheo C. Saquilayan", 10000, "201801106");
		 
		 insert(altheoAccount);
		 
		 altheoAccount.deposit(50000); //hands-on exercise
		 altheoAccount.withdraw(70000); //hands-on exercise
		 altheoAccount.withdraw(25000); //hands-on exercise
		 altheoAccount.transferFund("201801107", 35000); //hands-on exercise
		 altheoAccount.closeAccount(); //hands-on exercise
		 
		 BPI benedickAccount = new BPI();
		 
		 benedickAccount.openAccount("Benedick Macayan", 1000000, "201801053");
		 
		 insert(benedickAccount); 
		 benedickAccount.deposit(50000);
		 benedickAccount.withdraw(70000);
		 benedickAccount.withdraw(25000);
		 benedickAccount.transferFund("201801107", 35000);
		 benedickAccount.closeAccount();*/
		 
		 // BPI bpi = new BPI();
		 //bpi.listMutualFundOffer();
		 //bpi.submitRegistrationForm();
		 //bpi.submitGeneralInformationSheet();
		 
		 //bpi.createConnection();
		
		
		 /*BPI bpi = new BPI();
		 bpi.listMutualFundOffer();
		 bpi.submitRegistrationForm();
		 bpi.submitGeneralInformationSheet();*/
		 
		 ResultSet allRecords = new BPI().listRecords();
		 Display.printAllRecords(allRecords);
	}
	
	public static void insert(BPI customer) throws ClassNotFoundException, SQLException{
		System.out.println((customer.insertRecord())
			?"record inserted":"record NOT inserted");
	}
}

