package bpi.cc.exception;

/*
 * This ExpiredCreditCardException is of type runtime or unchecked exception
 */

public class ExpiredCreditCardException extends RuntimeException {

	public ExpiredCreditCardException() {
		//call the constructor of the parent to set the exception message
		super(Message.EXPIRED_CREDIT_CARD);

	}

	public ExpiredCreditCardException(String message){
		//call the constructor of the parent to set the exception message
		super(message);
	}
}
