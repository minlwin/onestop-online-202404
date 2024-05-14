public class OverloadingDemo {

	static int add(int a, int b) {
		System.out.println("Add with two int");
		return a + b;
	}

	static int add(int a, int b, int c) {
		System.out.println("Add with three int");
		return a + b + c;
	}

	static long add(long a, long b) {
		System.out.println("Add with two long");
		return a + b;
	}
}