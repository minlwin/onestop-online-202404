record Student(
	String name,
	String phone,
	String email
) {}

Student [] students = {
	new Student("Aung Aung", "0981171718", "aung@gmail.com"),
	new Student("Thidar", "0981171710", "thidar@gmail.com"),
	new Student("Nilar", "0981171722", "nilar@gmail.com"),
	new Student("Mya Mya", "0981171723", "mya@gmail.com"),
	new Student("Nyi Nyi", "0981171724", "nyi@gmail.com")	
}

void showStudents(Student [] students) {

	System.out.printf("%-12s", "Name");
	System.out.printf("%-12s", "Phone");
	System.out.printf("%-20s%n", "Email");

	for(var student : students) {
		System.out.printf("%-12s", student.name());
		System.out.printf("%-12s", student.phone());
		System.out.printf("%-20s%n", student.email());
	}
}