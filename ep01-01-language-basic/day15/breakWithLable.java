void search(int [][] arrays, int value) {

	int row = 0, col = 0;
	boolean found = false;

	outer :
	for (; row < arrays.length; row ++) {
		
		var array = arrays[row];

		for (col = 0; col < array.length; col ++) {
			
			if(value == array[col]) {
				found = true;
				break outer;
			}
		}
	}

	if(found) {
		System.out.printf("%d is found at row %d and col %d.%n", value, row, col);
	} else {
		System.out.printf("We can not find %d.", value);
	}
}

int[][] arrays = {
	{1, 2, 3},
	{4, 5, 6},
	{7, 8, 9}	
};