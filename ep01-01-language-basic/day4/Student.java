public class Student {

	String name;
	int age;

	static int count;

	public Student() {
		count ++;
	}

	public Student(String name) {
		this.name = name;
		count ++;
	}

	public Student(String name, int age) {
		this.name = name;
		this.age = age;
		count ++;
	} 

	void greet(Student otherPerson) {
		System.out.println("Hello! %s.".formatted(otherPerson.name));
		System.out.println("I am %s. I am %d years old.".formatted(name, age));
	}
}