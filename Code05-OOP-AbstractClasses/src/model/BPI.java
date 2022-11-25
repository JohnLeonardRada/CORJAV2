package model;

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

	public void setBalance(double balance) {
		this.balance = balance;
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
		this.balance = balance;
		
		System.out.println("A new savings account(" + this.accountNumber 
				+ ") has been opened for " + this.name);
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
		
		System.out.println("\nYour balance amount is Php " + this.balance);
		
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
	
	@Override
	public void listMutualFundOffer() {
		System.out.println(this.name + " offers mutual funds. These are \n"
				+ "\t1. ALFM Philippine Stock Index Fund\r\n" 
				+ "\t2. ALFM Growth Fund \n" 
				+ "\t3. ALFM Peso Bond Fund ");
		
	}

	@Override
	public void submitRegistrationForm() {
		System.out.println(this.name + "must submit the Registration Form "
				+ "within 7 days from the date of the occurrence of the event");
		
	}

	@Override
	public void submitGeneralInformationSheet() {
		System.out.println(this.name + "must submit the General Information Sheet "
				+ "Within 30 calendar days following the date of stockholder’s "
				+ "meeting per by-laws. If no meeting was held on that calendar year, "
				+ "on or before 30th of January of the following year.");
		
	}
	
}
