public class SumWithFor {

	public static void main(String[] args) {

		var intArray = new int[args.length];

		for (var i =0; i < args.length; i ++) {
			intArray[i] = Integer.parseInt(args[i]);
		}
		
		sum(intArray);
	}

	private static void sum(int [] array) {
		int total = 0;

		for (var i = 0; i < array.length; i++) {
			var element = array[i];
			total += element;
		}

		System.out.printf("Total is %d.%n", total);
	}
}