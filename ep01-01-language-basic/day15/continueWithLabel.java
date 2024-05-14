int countVowelWords(String string) {

	var words = string.split(" ");
	var count = 0;

	word :
	for(var word : words) {

		var chars = word.toCharArray();

		for(var c : chars) {
			if(c == 'a' 
				|| c == 'e' 
				|| c == 'i' 
				|| c == 'o' 
				|| c == 'u') {
				count ++;
				continue word;
			}
		}
	}

	return count;
}