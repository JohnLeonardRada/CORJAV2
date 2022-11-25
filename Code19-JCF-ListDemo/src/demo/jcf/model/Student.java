package demo.jcf.model;

public class Student {
	private String id;
	private String name;
	private String course;
	private int yearLevel;
	
	public Student() {
		
	}

	public Student(String id, String name, String course, int yearLevel) {
		this.id = id;
		this.name = name;
		this.course = course;
		this.yearLevel = yearLevel;
	}
	
	public void print(){
		System.out.println("ID: " + id 
			+ "\nName: " + name
			+ "\nCourse: " + course
			+ "\nYear Level: " + yearLevel);
	}
	
	/*@Override
	public String toString(){
		return "ID: " + id 
			+ "\nName: " + name
			+ "\nCourse: " + course
			+ "\nYear Level: " + yearLevel;
	}*/
	
	
	
	
	
}
