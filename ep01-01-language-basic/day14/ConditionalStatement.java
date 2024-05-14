String checkResult(int mark) {

	String result = "";

	if(mark >= 0 && mark < 40) {
		result = "Fails";
	} else if(mark >= 40 && mark < 80) {
		result = "Pass";
	} else if(mark >= 80 && mark < 100) {
		result = "Excellent";
	} else if(mark == 100) {
		result = "Perfect";
	} else {
		result = "Impossible";
	}

	return result;
}