package model;

public class LuhnFailedAlgorithmException extends RuntimeException{
	
	public LuhnFailedAlgorithmException() {
		super(Message.LUHN_FAILED_ALGORITHM);
	}
	
	public LuhnFailedAlgorithmException(String message) {
		super(message);
	}

}
