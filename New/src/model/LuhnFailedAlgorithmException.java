package model;

public class LuhnFailedAlgorithmException extends Exception{
	
	public LuhnFailedAlgorithmException(){
		//call the constructor of the parent to set the exception message
		super(Message.LUHN_FAILED_ALGORITHM_EXCEPTION);
	}
	
	public LuhnFailedAlgorithmException(String message){
		//call the constructor of the parent to set the exception message
		super(message);
	}
}
