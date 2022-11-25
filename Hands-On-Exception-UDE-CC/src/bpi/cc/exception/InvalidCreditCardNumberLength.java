package bpi.cc.exception;


public class InvalidCreditCardNumberLength extends RuntimeException {

	public InvalidCreditCardNumberLength() {
		//call the constructor of the parent to set the exception message
		super(Message.INVALID_CC_NUM_LENGTH);

	}

	public InvalidCreditCardNumberLength(String message){
		//call the constructor of the parent to set the exception message
		super(message);
	}
}
