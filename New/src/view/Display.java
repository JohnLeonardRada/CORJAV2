package view;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import model.*;

public class Display {

	
	public static void createLogFile(String dataToInput) {
		//creates a log file
		
		String logFile = "C:\\Users\\Benedick Macayan\\Desktop\\Core Java 2\\logfile.txt";
		
		   try {      
			   
			FileWriter write = new FileWriter(logFile,true);
			BufferedWriter bw = new BufferedWriter(write);
			
			bw.newLine();
			bw.write(dataToInput);
			
			bw.close();
			write.close();
			
			
		   } catch (FileNotFoundException fnfe) {
				System.out.println(fnfe.getMessage()); 
		   } catch (IOException ioe) {
			   	System.out.println(ioe.getMessage());
		   }
	}
	
	public static boolean luhnTest(String ccNumber){
        int s1 = 0, s2 = 0;
        String reverse = new StringBuffer(ccNumber).reverse().toString();
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
        }
        return (s1 + s2) % 10 == 0;
    }
	
	//exceptions
	public static boolean isValid(String ccNumber) throws InvalidCreditCardNumberLength,
	LuhnFailedAlgorithmException, StolenCreditCardException, NegativePriceException{
		
		boolean isValid = false;
		
		if (ccNumber.length()!= 16){//check if card number is == 16 digits
			throw new InvalidCreditCardNumberLength(); 
		}
		
		else if (!luhnTest(ccNumber)){//check LuhnTest algorithm 
			throw new LuhnFailedAlgorithmException();
		}
		
		else if (ccNumber.equals("5105105105105100")){ //Stolen Credit Card
			throw new StolenCreditCardException();
			
		}else if (ccNumber.equals("4111111111111111")){ //Expired Credit Card
			throw new ExpiredCreditCardException();
			
//		}else if (price){ //Negative Price Exception
//			throw new NegativePriceException();
//			
		}else{ //means that the new credit card number on the parameter is valid
			System.out.println("Customer credit card is valid.");
			isValid = true;
		}
		return isValid;
	}
	
	public static boolean priceChecker(double price) {
		
		boolean priceCheck = false;
		
		if(price < 0) {
			priceCheck = false;
		}else {
			priceCheck = true;
		}
		return priceCheck;
		
	}
	
	
	
}


