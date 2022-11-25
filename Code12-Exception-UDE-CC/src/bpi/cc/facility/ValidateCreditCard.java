package bpi.cc.facility;

import bpi.cc.exception.*;

public class ValidateCreditCard {

	/*
	 * This function will not handle the actual exception handling. It will rather create an exception
	 * exception specific object type based on the violation. Because the StolenCreditCardException
	 * is of type compile-time or checked exception and for the code to compile we have to throw it based
	 * on the throw new exception object.
	 */
	
	public static  boolean isValid(String ccNumber) throws StolenCreditCardException{
		
		boolean isValid = false;
		
		if(ccNumber.equals("5555555555554444")){ //tagged as stolen credit card
			throw new StolenCreditCardException();
		}else if(ccNumber.equals("4111111111111111")){ //tagged as expired credit card
			throw new ExpiredCreditCardException();
		}else{ //means that the credit card number on the parameter is valid
			System.out.println("Customer credit card is valid");
			isValid = true;
		}
		return isValid;
	}
}
