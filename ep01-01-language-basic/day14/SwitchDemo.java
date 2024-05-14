enum Days {
	MON, TUE, WED, THU, FRI, SAT, SUN
}

String checkDay(Days day) {
	String result = "";

	switch(day) {
	case MON, TUE, WED, THU, FRI:

		switch(day) {
		case MON:
			System.out.println("First Weekday");
			break;
		case FRI:
			System.out.println("Last Weekday");	
		}

		result = "Weekday";
		break;
	default:
		result = "Weekend";
	}

	return result;
}

String checkDayWithArrow(Days day) {
	String result = "";

	switch(day) {

	case MON, TUE, WED, THU, FRI -> {
		switch(day) {
		case MON -> System.out.println("First Weekday");
		case FRI -> System.out.println("Last Weekday");	
		}

		result = "Weekday";
	}

	default -> result = "Weekend";
	}

	return result;
}

String checkDayWithExpression(Days day) {
	return switch(day) {

	case MON, TUE, WED, THU, FRI -> {
		switch(day) {
		case MON -> System.out.println("First Weekday");
		case FRI -> System.out.println("Last Weekday");	
		}

		yield "Weekday";
	}

	default -> "Weekend";
	};
}

String checkDayWithExpressionLabel(Days day) {
	return switch(day) {

	case MON, TUE, WED, THU, FRI: 
		switch(day) {
		case MON -> System.out.println("First Weekday");
		case FRI -> System.out.println("Last Weekday");	
		}

		yield "Weekday";

	default: 
		yield "Weekend";
	};
}