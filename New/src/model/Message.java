package model;

public interface Message {
	
	String STOLEN_CREDIT_CARD = "\nALERT!!! This credit card is stolen."
			+ "\nCall the police to apprehend this criminal.";
	
	String EXPIRED_CREDIT_CARD = "\nALERT!!! This credit card is expired."
			+ "\nGet a scissor and cut this card.";
	
	String INVALID_CREDIT_CARD_NUMBER_LENGTH = "\nALERT!!! "
			+ "This credit card has invalid credit card number length.";
	
	String LUHN_FAILED_ALGORITHM_EXCEPTION = "\nALERT!!! "
			+ "This credit card has failed LUHN's Algorithm.";
	
	String INVALID_CUSTOMER_NAME = "\nALERT!!! "
			+ "Invalid customer name!";
	
	String INVALID_PRICE = "\nALERT!!! "
			+ "Invalid product price!";
	
	String INVALID_PRODUCT_NAME = "\nALERT!!! "
			+ "Invalid product name!";
}
