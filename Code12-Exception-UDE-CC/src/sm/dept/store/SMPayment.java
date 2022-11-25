package sm.dept.store;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import bpi.cc.exception.StolenCreditCardException;
import bpi.cc.exception.ExpiredCreditCardException;

import bpi.cc.facility.ValidateCreditCard;

public class SMPayment {

	public static void main(String[] args) {
		
		try{
			String customerName = getString("Enter customer name: ");
			String productName = getString("Enter product name: ");
			double amount = getDouble("Enter purchased amount: ");
			String ccNumber = getString("Enter credit card number: ");
			
			if(ValidateCreditCard.isValid(ccNumber)){
				System.out.println("Thank you customer " + customerName +
								   " for paying the amount of " + amount + 
								   " for buying " + productName);
									
				System.out.println("Because at SM, we\'ve got it all for you.");
			}
		}catch(IOException ioe){
			System.out.println(ioe.getMessage());
		}catch(StolenCreditCardException scce){
			System.err.println(scce.getMessage());
		}catch(ExpiredCreditCardException ecce){
			System.err.println(ecce.getMessage());
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			System.out.println("Program terminated.");
		}

	}
	
	public static String getString(String message) throws IOException{
		BufferedReader reader = new BufferedReader(
			new InputStreamReader(System.in));
			
		System.out.print(message);
		return reader.readLine();
		
	}
	
	public static double getDouble(String message) throws IOException{
		BufferedReader reader = new BufferedReader(
			new InputStreamReader(System.in));
			
		System.out.print(message);
		return Double.parseDouble(reader.readLine());
		
	}

}
