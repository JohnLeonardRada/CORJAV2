package model;

/* 
 	this StolenCreditCardException is the type compile-time or checked exception
 */
public class StolenCreditCardException extends Exception {
	
	public StolenCreditCardException(){
		//call the constructor of the parent to set the exception message
		super(Message.STOLEN_CREDIT_CARD);
	}
	
	public StolenCreditCardException(String message){
		//call the constructor of the parent to set the exception message
		super(message);
	}

}
