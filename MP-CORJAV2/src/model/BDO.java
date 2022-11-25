package model;

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
		this.name = name;
		this.balance = amount;
		this.accountNumber = accountNumber;
		System.out.println("A new savings account(" + this.accountNumber 
			+ ") has been opened for " + this.name);

		
		balanceInquiry();		
	}
	
	public void deleteAccount(String accountNumber) {
		this.name = null;
		this.balance = 0;
		this.accountNumber = null;
		
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
	public void balanceInquiry(String accountNumber, double amount) {
		// TODO Auto-generated method stub
		
	}

	

}
