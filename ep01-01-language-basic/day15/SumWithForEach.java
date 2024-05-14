public class SumWithForEach {

	public static void main(String[] args) {

		var intArray = new int[args.length];

		for (var i = array.length - 1; i >= 0; i --) {
			intArray[i] = Integer.parseInt(args[i]);
		}
		
		sum(intArray);
	}

	private static void sum(int [] array) {
		int total = 0;

		for (var element : array) {
			total += element;
		}

		System.out.printf("Total is %d.%n", total);
	}
}