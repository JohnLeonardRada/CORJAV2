package bpi.cc.facility;

import bpi.cc.exception.*;

public class ValidateCreditCard {

	/*
	 * This function will not handle the actual exception handling. It will rather create an exception
	 * exception specific object type based on the violation. Because the StolenCreditCardException
	 * is of type compile-time or checked exception and for the code to compile we have to throw it based
	 * on the throw new exception object.
	 */
	
	public static  boolean isValid(String ccNumber) throws StolenCreditCardException, LuhnFailedAlgorithmException{
		
		boolean isValid = false;
		
		
		if(ValidateCreditCard.luhnTest(ccNumber) == false){
			throw new LuhnFailedAlgorithmException();
		}
		else if(ccNumber.equals("5555555555554444")){ //tagged as stolen credit card
			throw new StolenCreditCardException();
		}else if(ccNumber.equals("4111111111111111")){ //tagged as expired credit card
			throw new ExpiredCreditCardException();	
		}else { //means that the credit card number on the parameter is valid
			System.out.println("Customer credit card is valid");
			isValid = true;
		}
		return isValid;
	}
	    
	 public static boolean luhnTest(String number){
	        int s1 = 0, s2 = 0;
	        String reverse = new StringBuffer(number).reverse().toString();
	        for(int i = 0 ;i < reverse.length();i++){
	            int digit = Character.digit(reverse.charAt(i), 10);
	            if(i % 2 == 0){//this is for odd digits, they are 1-indexed in the algorithm
	                s1 += digit;
	            }else{//add 2 * digit for 0-4, add 2 * digit - 9 for 5-9
	                s2 += 2 * digit;
	                if(digit >= 5){
	                    s2 -= 9;
	                }
	            }
	        }
	        return (s1 + s2) % 10 == 0;
	    }
	 
	 public static boolean checkCcNumLength(String ccNumber){
		 	
		 	boolean isEqual = false;
		 	
		 	if(ccNumber.length()!= 16){
		 		throw new InvalidCreditCardNumberLength();
		 	} else{
		 		isEqual = true;
		 	}
		 	
		 return isEqual;
	 }
	    
}
		

