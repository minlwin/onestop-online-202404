public class Person {

	String name;
	int age;

	void greet() {
		System.out.println(
			"Hello! I am %s, and %d years old."
			.formatted(name, age));
	}
}