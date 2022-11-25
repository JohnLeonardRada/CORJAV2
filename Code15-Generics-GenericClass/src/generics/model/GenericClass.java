package generics.model;

public class GenericClass<A> {
	private A data; 
	
	public GenericClass(){
	}
	
	public GenericClass(A data){
		this.data = data;
	}
	
	public void setData(A data){
		this.data = data;
	}
	
	public A getData(){
		return data;
	}
	
	
}
