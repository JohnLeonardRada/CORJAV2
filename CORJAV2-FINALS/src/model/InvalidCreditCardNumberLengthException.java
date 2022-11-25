package model;

public class InvalidCreditCardNumberLengthException extends RuntimeException {
	
	public InvalidCreditCardNumberLengthException() {
		super(Message.INVALID_CC_NUM_LENGTH);
	}
		
	public InvalidCreditCardNumberLengthException(String message) {
		super(message);
	}
}
