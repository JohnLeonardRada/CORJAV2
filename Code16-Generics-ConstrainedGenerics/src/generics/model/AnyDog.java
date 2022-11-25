package generics.model;

public class AnyDog <MyDog extends Dog> {

		public void displayName(String name){
			System.out.println("Dog Type: " + name);
		}
}
