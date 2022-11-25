package model;

public class NegativePriceException extends Exception {
	
	public NegativePriceException(){
		//call the constructor of the parent to set the exception message
		super(Message.INVALID_PRICE);
	}
	
	public NegativePriceException(String message){
		//call the constructor of the parent to set the exception message
		super(message);
	}

}
