package model;

public class InvalidProductPriceException extends RuntimeException {
	
	public InvalidProductPriceException() {
		super(Message.INVALID_PRODUCT_PRICE);
	}
	
	public InvalidProductPriceException(String message) {
		super(message);
	}
}
