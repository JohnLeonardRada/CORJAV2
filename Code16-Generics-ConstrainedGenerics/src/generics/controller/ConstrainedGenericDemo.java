package generics.controller;

import generics.model.*;

public class ConstrainedGenericDemo {

	public static void main(String[] args) {
		//AnyDog<Bulldog> dogtype = new AnyDog<Bulldog>();
		//dogType.displayName("Canis Lupus familiaris aka Bulldog")
		
		new AnyDog<Bulldog>().displayName("Canis Lupus familiaris aka Bulldog");
		new AnyDog<Rottweiler>().displayName("Canis Lupus familiaris aka Rottweiler");
		new AnyDog<GermanSheperd>().displayName("Canis Lupus familiaris aka German Sheperd");
		
		new AnyDog<AlienDog>().displayName("Internecivus raptus aka Alien Dog");
		new AnyDog<Dog>().displayName("Canis Lupus familiaris the Dog");
		
		//new AnyDog<Mammal>().displayName("Mammalia");
		
		

	}

}
