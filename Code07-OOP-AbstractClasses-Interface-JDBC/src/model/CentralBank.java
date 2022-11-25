package model;

public abstract class CentralBank {
	
	public String name;
	
	public CentralBank() {
		name = "Bangko Sentral ng Pilipinas";
	}
	
	abstract public void openAccount(String name, double amount, String accountNumber);
	abstract public void deposit(double amount);
	abstract public void withdraw(double amount);
	abstract public void balanceInquiry();
	abstract public void transferFund(String targetAccountNumber, double amount);
	abstract public void closeAccount();
	
	public final void insuranceMessage() {
		System.out.println("\n\nDeposits are insured by PDIC up to P500,000 "
				+ "per depositor. PDIC is an attached agency of the "
				+ "Department of Finance");
	}
}
