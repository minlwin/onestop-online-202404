public class OwnerDemo {

	static String message = "Static Message";
	static int count;

	String name = "Instance Name";
	int age;

	void hidingDemo() {
		String name = "Local Name";
		System.out.println(name);
		System.out.println(this.name);

		String message = "Local Message";
		System.out.println(message);
		System.out.println(OwnerDemo.message);
	}

	void doSomething(int count) {

		String data;

		data = "Hello";
		System.out.println(data);

		System.out.println(count);

		for(int i = 0; i < count; i ++) {

		}
	}
}