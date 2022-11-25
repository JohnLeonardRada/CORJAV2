package utility;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;

import model.*;

	public class Reader {

		public static BufferedReader getReader() {

			BufferedReader reader = new BufferedReader(

					new InputStreamReader(System.in));

			return reader;

		}

		public static String readString(String message) {

			String input = null;

			try {

				System.out.print(message +": ");

				input = getReader().readLine();	

			} catch (Exception e) {

			}

			return input;

		}

		public static int readInt(String message) {

			int input = 0;

			try {

				System.out.print(message +": ");

				/*The parseInt method converts a String value

				to an equivalent int value*/

				input = Integer.parseInt(getReader().readLine());

			} catch (Exception e) {

			}

			return input;

		}

		public static double readDouble(String message) {

			double input = 0;

			try {

				System.out.print(message +": ");

				/*The parseInt method converts a String value

	to an equivalent double value*/

				input = Double.parseDouble(getReader().readLine());

			} catch (Exception e) {

			}

			return input;

		}
		
		public static void createXMLDatabaseFile(CustomerBean students) {
			System.out.println("\nPlease Wait.. \nCreating an XML Database...");		
			
			try {
				XMLEncoder encoder = null;
				encoder = new XMLEncoder(
					new BufferedOutputStream(
				    //
							new FileOutputStream("C:\\Users\\Benedick Macayan\\Desktop\\Core Java\\db.xml")));			
				 encoder.writeObject(students);
				 encoder.close();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
			
	}