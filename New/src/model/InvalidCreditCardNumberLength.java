package model;

public class InvalidCreditCardNumberLength extends Exception{
	
	public InvalidCreditCardNumberLength(){
		//call the constructor of the parent to set the exception message
		super(Message.INVALID_CREDIT_CARD_NUMBER_LENGTH);
	}
	
	public InvalidCreditCardNumberLength(String message){
		//call the constructor of the parent to set the exception message
		super(message);
	}
}
