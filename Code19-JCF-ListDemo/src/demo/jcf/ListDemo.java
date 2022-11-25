package demo.jcf;

import java.util.*;
import demo.jcf.model.*;

public class ListDemo {

	public static void main(String[] args) {
		/*
		 Increases performance by providing high-performance
		 implementations of data structures and algorithms. 
		 Because the various implementations of each interface are interchangeable, 
		 programs can be tuned by switching implementations.
		 */
		
		List uaapSchool = new ArrayList();
		
		System.out.println(uaapSchool.add("De La Salle University Green Archers"));
		System.out.println(uaapSchool.add("University of Santo Tomas Growling Tigers"));
		System.out.println(uaapSchool.add("iACADEMY CheerFuL Game Changers"));
		System.out.println(uaapSchool.add("University of the Philippines Diliman Fighting Maroons"));
		System.out.println(uaapSchool.add("Ateneo de Manila University Blue Eagles"));
		System.out.println(uaapSchool.add("Far Eastern University Tamarraws"));
		System.out.println(uaapSchool.add("iACADEMY CheerFuL Game Changers"));
		System.out.println(uaapSchool.add("Adamson University Soaring Falcons"));
		System.out.println(uaapSchool.add("University of the East Red Warriors"));
		System.out.println(uaapSchool.add("National University Bulldogs"));
		System.out.println(uaapSchool.add("iACADEMY CheerFuL Game Changers"));
		
		//integer number collection
				System.out.println(uaapSchool.add(new Integer(2002)));
				
				//Student collection
				System.out.println(uaapSchool.add(new Student("201223456", "Yorme Saquilayan model of SE", "BS CS", 2)));
				System.out.println(uaapSchool.add(new Student("201223457", "John Macayan another model of SE", "BS CS", 2)));
				
				//array collection
				String yormeSubject[] = {"Soft Eng", "Filipino", "RIZLIFE", 
					"UML", "WEBPROG", "CSELEC02"};
				double yormeGradeThisTerm[] = {1.0, 1.25, 1.5, 1, 1.5, 1};
				
				System.out.println(uaapSchool.add(yormeSubject));
				System.out.println(uaapSchool.add(yormeGradeThisTerm));
				
				System.out.println("\nTotal schools on the list: " 
						+ uaapSchool.size());
				System.out.println("Quick list view: " + uaapSchool);
				
				//iterate thru the list collection using Iterator interface
				Iterator uaapIterator = uaapSchool.iterator();
				
				System.out.println("\nUsing the Iterator interface");
				
				while (uaapIterator.hasNext()) {
					Object obj = uaapIterator.next();
					
					if (obj instanceof String) {
						System.out.println("Type String collection:");
						//System.out.println("\t" + (String) obj);
						//since you are not using toString, use this. 
						((Student) obj).print();
 					} else if (obj instanceof Student) {
						System.out.println("Type Student collection:");
						System.out.println("\t" + (Student) obj);
					} else if (obj instanceof Integer) {
						System.out.println("Type int collection:");
						System.out.println("\t" + (Integer) obj);
					} else if (obj instanceof String[]) {
						System.out.println("\nSubjects of 2nd year students collection:");
						for (String asignatura : (String[])obj ) {
							System.out.println(asignatura);
						}				
					} else if (obj instanceof double[]) {
						System.out.println("\nGrades of Yorme this term: ");
						double average = 0;
						double summation = 0;
						
						for (double grade : (double []) obj) {
							System.out.println(grade);
							summation += grade;
						}
						System.out.println("Average: " 
							+ (summation/((double []) obj).length));
					}
				}
			}
		
	}

