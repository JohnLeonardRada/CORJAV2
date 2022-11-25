package controller;

import model.*;

public class AbstractDemo {
	
	public static void main(String[] args) {
	 
	BPI leonardAccount = new BPI();
	
	leonardAccount.openAccount("Altheo C. Saquilayan", 10000, "201801141");
	leonardAccount.deposit(20000);
	leonardAccount.withdraw(10000);
	leonardAccount.withdraw(10000);
	leonardAccount.transferFund("201801141", 30000); 
	leonardAccount.closeAccount();
	
	BDO benedickAccount = new BDO();
	
	benedickAccount.openAccount("Benedick Macayan", 1000000, "201801053");
	benedickAccount.deposit(50000);
	benedickAccount.withdraw(70000);
	benedickAccount.withdraw(25000);
	benedickAccount.transferFund("201801107", 35000);
	benedickAccount.closeAccount();
	
	BPI bpi = new BPI();
	
	bpi.listMutualFundOffer();
	bpi.submitRegistrationForm();
	bpi.submitGeneralInformationSheet();
	
	
	if (bpi instanceof CentralBank) {
		System.out.println("bpi is a child of CentralBank"); 
	 } else {
		 System.out.println("bpi is NOT a child of CentralBank");
	 }
	 
	 if (bpi instanceof SEC) {
		System.out.println("bpi is a child of SEC"); 
	 } else {
		 System.out.println("bpi is NOT a child of SEC");
	 }
	 
	 if (bpi instanceof DBOperations) {
		System.out.println("bpi is a child of DBOperations"); 
	 } else {
		 System.out.println("bpi is NOT a child of DBOperations");
	 }
	
	}

}
