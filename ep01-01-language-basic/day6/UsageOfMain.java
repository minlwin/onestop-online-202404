public class UsageOfMain {

	public static void main(String[] args) {
		
		if(args.length > 0) {
			
			System.out.println("There are %s arguments."
				.formatted(args.length));

			for(var data : args) {
				System.out.println(data);
			}
		} else {
			System.out.println("There is no arguments.");
		}
	}
}