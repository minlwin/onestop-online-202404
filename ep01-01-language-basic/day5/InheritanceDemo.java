class Animal {

	String type = "Animal";

	void greet() {
		System.out.println("Hello! I am animal.");
	}
}

// Inheritance
// IS A Relationship
// Dog is an Animal
class Dog extends Animal {

	void greet() {
		System.out.println("Wote Wote");
	}

	void shakeTail() {
		System.out.println("Shaking Shaking");
	}
}

// For JShell Only
Animal getInstance(boolean animal) {

	if(animal) {
		return new Animal();
	}

	return new Dog();
}