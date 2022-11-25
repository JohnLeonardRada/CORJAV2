package model;

import java.sql.SQLException;

public abstract class CentralBank {

	public String name;
	
	public CentralBank (){
		name = "Bangko Sentral ng Pilipinas";
	}
	
	abstract public void openAccount(String name, double amount,String accountNumber) throws ClassNotFoundException, SQLException;
	abstract public void deleteAccount(String accountNumber);	
	abstract public void withdraw(double amount);
	abstract public void balanceInquiry(String accountNumber, double amount);


	public void balanceInquiry() {
		// TODO Auto-generated method stub
		
	}

	public void searchAccount(String name, double amount, String accountNumber) {
		// TODO Auto-generated method stub
		
	}

	public void searchAccount(String accountNumber) {
		// TODO Auto-generated method stub
		
	}

}
