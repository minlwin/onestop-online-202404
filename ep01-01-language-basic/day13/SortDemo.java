record Data(int id, String name) implements Comparable<Data>{

	public int compareTo(Data other) {
		var result = this.id() - other.id();

		if(result == 0) {
			return this.name().compareTo(other.name());
		}

		return result;
	}
}

Data [] array = {
	new Data(1, "Java"), 
	new Data(2, "Spring"), 
	new Data(3, "Angular")
};

Comparator<Data> nameAsc = (a, b) -> a.name().compareTo(b.name());
Comparator<Data> nameDesc = (a, b) -> b.name().compareTo(a.name());
Comparator<Data> idDesc = (a, b) -> b.id() - a.id();
