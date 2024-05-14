package com.jdc.bot.model.impl;

public class DictionaryLinear extends AbstractDictionary {
	
	protected Entry[] entries;

	public DictionaryLinear(int capacity) {
		super();
		this.capacity = capacity;
		this.entries = new Entry[capacity];
	}

	@Override
	public int register(String question, String answer) {
		
		if(size < capacity) {
			var hash = hash(question);
			var entry = entries[hash];
			
			if(null == entry) {
				entries[hash] = new Entry(question, answer);
			} else {
				if(entry.question().equals(question)) {
					entries[hash] = new Entry(question, answer);
					return size;
				} else {
					var index = (hash + 1) % capacity;
					while(true) {
						if(null == entries[index]) {
							entries[index] = new Entry(question, answer);
							break;
						}
						
						index = (index + 1) % capacity;
					}
				}
			}
			
			return ++ size;
		}
		
		return -1;
	}

	@Override
	public String search(String question) {
		
		if(size > 0) {
			var hash = hash(question);
			var entry = entries[hash];
			
			if(null != entry) {
				if(entry.question().equals(question)) {
					return entry.answer();
				}
				
				var index = (hash + 1) % capacity;
				
				for(;;) {
					
					if(hash == index) {
						break;
					}
					
					var next = entries[index];
					if(next.question().equals(question)) {
						return next.answer();
					}	
					
					index = (index + 1) % capacity;
				}
			}
		}
		
		return null;
	}
}
