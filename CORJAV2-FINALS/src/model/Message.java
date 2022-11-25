package model;

public interface Message {
	String LUHN_FAILED_ALGORITHM = "ALERT!!! This card is invalid. Call the bank.";
	String INVALID_CC_NUM_LENGTH = "ALERT!!! Invalid credit card number length";
	String INVALID_PRODUCT_PRICE = "ALERT!!! Invalid Price Range";
}
