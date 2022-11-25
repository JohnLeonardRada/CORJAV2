package generic.method;

public class GenericMethodDemo {

		public static void main(String[] args){
			//create an array of integer using initialization declaration
			Integer number[] = {5, 10, 15, 20, 25};
			
			//create an array of boolean using initialization declaration
			Boolean booleanVar[] = {true, false, true, true, false};
			
			//create an array of String using initialization declaration
			String dallasMavs[] = {"Dirk Nowitzki,", "Luka Doncic,", "Kristaps Porzingis,", "Timmy Hardaway Jr,", "Set Curry"};
			
			Double gradesForThisTerm[] = {1.0, 1.25, 1.0, 1.0, 2.5};
			
			//print integer array content
			printArray("Integer Array", number);
			
			//print boolean array content
			printArray("Boolean Array", booleanVar);
			
			//print String array content
			printArray("String Array", dallasMavs);
			
			//print double array content
			printArray("Double Array", gradesForThisTerm);
	
			}
		
//		public static void printArray(int numero[]){
//			System.out.println("Array integer contains: ");
//			for(int counter = 0; counter < numero.length; counter++){
//				System.out.println(numero[counter] + " ");
//			}
//		}
//		
//		public static void printArray(boolean value[]){
//			System.out.println("Array integer contains: ");
//			for(int counter = 0; counter < value.length; counter++){
//				System.out.println(value[counter] + " ");
//			}
//		}
//		
//		public static void printArray(String value[]){
//			System.out.println("Array integer contains: ");
//			for(int counter = 0; counter < value.length; counter++){
//				System.out.println(value[counter] + " ");
//			}
//		}
		
//		public static void printArray(Object obj){
//			if(obj instanceof int[]){
//				System.out.print("ONE METHOD -- Array integer contains: ");
//				for(int value: (int[]) obj){
//					System.out.print(value + " ");
//				}
//			}else if (obj instanceof boolean[]){
//				System.out.print("ONE METHOD -- Array boolean contains: ");
//				for(boolean value: (boolean[]) obj){
//					System.out.print(value + " ");
//				}
//			}else if (obj instanceof String[]){
//				System.out.print("ONE METHOD -- Array String contains: ");
//				for(String value: (String[]) obj){
//					System.out.print(value + " ");
//				}
//			}
//		}
		
		public static <AA> void printArray(String typeArray, AA[] value){
			System.out.print(typeArray + ": ");
			for(AA laman: value){
				System.out.print(laman + " ");
			}
			System.out.println();
		}
}
