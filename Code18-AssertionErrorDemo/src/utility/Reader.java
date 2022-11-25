package utility;

import java.io.*;

public class Reader {
	
		public static BufferedReader getReader (){
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			return reader;
		
		}
		
		public static String readString(String message){
			String input = null;
			try{
				System.out.print(message + ":");
				
				input = getReader().readLine();
			}catch (Exception e){
			}
			return input;
		}
		
		public static int readInt(String message) {
			int input = 0;
			
			try {
				System.out.print(message + ":");
				input = Integer.parseInt(getReader().readLine());
			} catch (Exception e){
				
			}
			
			return input;
		}
		
		

}
