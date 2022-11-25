package model;

import java.sql.Connection;
import java.sql.ResultSet;

public class BDO extends CentralBank {

	private String name;
	private double balance;
	private String accountNumber;
	
	public BDO() {
		name = "Banco de Oro";
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double amount) {
		this.balance = amount;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	@Override
	public void openAccount(String name, double amount, String accountNumber) {
		this.accountNumber = accountNumber;
		this.name = name;
		this.balance = amount;
		System.out.println("A new savings account(" + this.accountNumber 
			+ ") has been opened for " + this.name);
		System.out.println("Because you opened an account, you have a dinner date with Pia Wurtzbach.");
		
		balanceInquiry();		
		insuranceMessage();
	}

	@Override
	public void deposit(double amount) {
		this.balance+=amount;
		balanceInquiry();
	}

	@Override
	public void withdraw(double amount) {
		if (amount <= balance) {
			this.balance-=amount; // balance = balance - amount;			
		} else {
			System.out.println("\nInvalid amount - higher than "
				+ "the available balance amount.");
		}
		balanceInquiry();		
	}

	@Override
	public void balanceInquiry() {
		System.out.println("\nYour balance amount is Php" + this.balance);
	}

	@Override
	public void transferFund(String targetAccountNumber, double amount) {
		if (amount <= balance) {
			this.balance-=amount; // balance = balance - amount;
			System.out.println("\nThe amount of Php" + amount 
				+ " is successfully transferred to account number " 
				+ targetAccountNumber);
		} else {
			System.out.println("\nInvalid amount - higher than "
				+ "the available balance amount.");
		}
		balanceInquiry();
	}

	@Override
	public void closeAccount() {
		this.name = null;
		this.accountNumber=null;
		this.balance = 0;
		System.out.println("\nSuccessfully closed the account.");
	}
}
