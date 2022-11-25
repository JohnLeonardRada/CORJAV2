package model;

import java.sql.*;

public class BPI extends CentralBank implements SEC {

	private String name;
	private double balance;
	private String accountNumber;
	
	public BPI() {
		name = "Bank of the Philippine Islands";
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
	public void openAccount(String name, double amount, String accountNumber) throws ClassNotFoundException, SQLException {
		table();
		if(accountNumber != this.accountNumber) {
			System.out.println("CREATING A NEW ACCOUNT...");
			timer();
			this.name = name;
			this.balance = amount;
			this.accountNumber = accountNumber;
			System.out.println("A new savings account(" + this.accountNumber + ") has been opened for " + this.name);		
		}else {
			System.out.println("ACCOUNT NUMBER ALREADY TAKEN");
		}
	}
	
	@Override
	public void searchAccount(String name, double amount, String accountNumber) {
		if(accountNumber != this.accountNumber) {
			System.out.println("SEARCHING FOR DATA...");
			timer();
			System.out.println("DATA NOT LOCATED");
		}else {
			System.out.println("DATA LOCATED");
			System.out.println("Name: " + this.name + "\nBalance: " + this.balance + "\nAccount Number: " + this.accountNumber);
		}
	}
	
	@Override
	public void balanceInquiry(String accountNumber, double amount) {
		if(accountNumber != this.accountNumber) {
			System.out.println("SEARCHING FOR DATA...");
			timer();
			System.out.println("DATA NOT LOCATED");
		}else {
			System.out.println("SEARCHING FOR DATA...");
			timer();
			System.out.println("DATA LOCATED");
		}
		
	}
	
	public void listAccount(String name, double amount, String accountNumber) {
			
	}
	
	@Override
	public void withdraw(double amount) {
		if (amount <= balance) {
			this.balance-=amount; 			
		} else {
			System.out.println("\nInvalid amount - higher than "
				+ "the available balance amount.");
		}		
	}

	
	@Override
	public void deleteAccount(String accountNumber) {
		if(accountNumber != this.accountNumber) {
			System.out.println("SEARCHING FOR DATA...");
			timer();
			System.out.println("DATA NOT LOCATED");
		}else {
			System.out.println("DATA LOCATED");
			System.out.println("DELETING RECORD...");
			timer();
			this.name = null;
			this.balance = 0;
			this.accountNumber = null;
		}
	
	}
	
	public static void timer() {

		try{
		    Thread.sleep(1000);
		}
		catch(InterruptedException ex){
		    Thread.currentThread().interrupt();
		}

	}
	

	

	@Override
	public Connection createConnection() throws ClassNotFoundException, SQLException {
		
		Connection connection = null;
		
		//enroll the Oracle MySql JDBC Driver
		Class.forName(JDBC_DRIVER_NAME);
		
		//create or get a Connection
		connection = DriverManager.getConnection(JDBC_URL,DB_USER_NAME, DB_PASSWORD);
		
		if (connection != null) {
			System.out.println("CONNECTION TO DATABASE IS VALID");
		} else {
			System.out.println("CONNECTION TO DATABASE IS INVALID");
		}
		
		return connection;
	}
	
	public ResultSet table() throws ClassNotFoundException, SQLException {
		ResultSet checkTable = null;
		
		Connection table =  createConnection(); 
		
		if (table != null) {
			//PreparedStatement object
			PreparedStatement ptsmnt = table.prepareStatement(TABLE);
			
			checkTable = ptsmnt.executeQuery();
		}	
		return checkTable;
	}

	@Override
	public boolean insertRecord() throws ClassNotFoundException, SQLException {
		boolean isSuccess = false;
		
		Connection insert =  createConnection(); 
		
		if (insert != null) {
			//PreparedStatement object
			PreparedStatement ptsmnt = insert.prepareStatement(INSERT_RECORD);
			
			ptsmnt.setString(1, this.name);
			ptsmnt.setDouble(2, this.balance);
			ptsmnt.setString(3, this.accountNumber);
			
			ptsmnt.executeUpdate();			
			isSuccess = true;
		} 
		return isSuccess;
	}
	
	@Override
	public boolean searchRecord() throws ClassNotFoundException, SQLException {
		boolean isLocated = false;
		
		Connection location =  createConnection(); 
		
		if (location != null) {
			//PreparedStatement object
			PreparedStatement ptsmnt = location.prepareStatement(SEARCH_RECORD);
			
			ptsmnt.setString(1, this.name);
			ptsmnt.setDouble(2, this.balance);
			ptsmnt.setString(3, this.accountNumber);
			
			ptsmnt.executeUpdate();			
			isLocated = true;
		} 
		return isLocated;
	}
	
	@Override
	public ResultSet balanceRecord() throws ClassNotFoundException, SQLException {
		
		ResultSet checkBalance = null;
		
		Connection balance =  createConnection(); 
		
		if (balance != null) {
			//PreparedStatement object
			PreparedStatement ptsmnt = balance.prepareStatement(BALANCE_INQUIRY);
			
			checkBalance = ptsmnt.executeQuery();
		}	
		return checkBalance;
	}

	@Override
	public ResultSet listRecord() throws ClassNotFoundException, SQLException{
		
		ResultSet records = null;
		
		Connection connection =  createConnection(); 
		
		if (connection != null) {
			//PreparedStatement object
			PreparedStatement ptsmnt = connection.prepareStatement(LIST_ALL_RECORDS);
			
			records = ptsmnt.executeQuery();
		}	
		return records;
	}
	
	@Override
	public boolean withdrawRecord() throws ClassNotFoundException, SQLException {
	
		boolean isUpdated = false; 
		
		Connection update = createConnection();
		
		if (update != null) {
			PreparedStatement ptsmnt = update.prepareStatement(WITHDRAW);
				
				ptsmnt.setString(1, this.accountNumber);
				
				ptsmnt.executeUpdate();			
				isUpdated = true;
		}
		return isUpdated;
	}

	@Override
	public boolean deleteRecord() throws ClassNotFoundException, SQLException {
		boolean isSuccess = false; 
		
		Connection connection = createConnection();
		
		if (connection != null) {
			PreparedStatement ptsmnt = connection.prepareStatement(DELETE_RECORD);
				
				ptsmnt.setString(1, this.name);
				ptsmnt.setDouble(2, this.balance);
				ptsmnt.setString(3, this.accountNumber);
				
				ptsmnt.executeUpdate();			
				isSuccess = true;
		}
		return isSuccess;
	
	}


}
