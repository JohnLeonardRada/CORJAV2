package facility;

import model.InvalidProductPriceException;

public class ValidateProductPrice {

	//VALIDATION OF PRICE
	public static boolean ValidatePrice(double price){
		
		boolean isPositive = false;
		
		if(price > 0) {
			isPositive = true;
		}else {
			isPositive = false;
			throw new InvalidProductPriceException();
		}
		return isPositive;
	}
}

