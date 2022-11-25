package bpi.cc.exception;

public class LuhnFailedAlgorithmException extends Exception {

	public LuhnFailedAlgorithmException() {
		//call the constructor of the parent to set the exception message
		super(Message.LUHN_FAILED_ALGORITHM);

	}

	public LuhnFailedAlgorithmException(String message){
		//call the constructor of the parent to set the exception message
		super(message);
	}
}
