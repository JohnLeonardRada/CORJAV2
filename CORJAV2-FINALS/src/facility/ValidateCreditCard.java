package facility;

import model.InvalidCreditCardNumberLengthException;
import model.LuhnFailedAlgorithmException;

public class ValidateCreditCard {
	
	//VALIDATION OF NUMBER LENGTH
	public static boolean Validate(String ccNumber) throws LuhnFailedAlgorithmException{
		
		int count = ccNumber.length();
		boolean isValid = false;
		
		if (count != 16) {
			throw new InvalidCreditCardNumberLengthException();
		}else {
			if(luhnTest(ccNumber)){
				System.out.println("Customer credit card is valid");
			}else{
				throw new LuhnFailedAlgorithmException();
			}
			isValid = true;
		}
		return isValid;
	}
	//VALIDATION OF LUHN ALGORITHM
	public static boolean luhnTest(String luhn) {
		
		boolean test = false;
		int s1 = 0;
		int s2 = 0;
		
		String reverse = new StringBuffer().reverse().toString();
		
		for(int i = 0 ;i < reverse.length();i++){
            int digit = Character.digit(reverse.charAt(i), 10);
            if(i % 2 == 0){//this is for odd digits, they are 1-indexed in the algorithm
                s1 += digit;
            }else{//add 2 * digit for 0-4, add 2 * digit - 9 for 5-9
                s2 += 2 * digit;
                if(digit >= 5){
                    s2 -= 9;
                }
            }
        }if (s1 + s2 % 10 == 0) {
        	test = true;
        }else {
        	test = false;
        }
		return test;
	}
	
}
