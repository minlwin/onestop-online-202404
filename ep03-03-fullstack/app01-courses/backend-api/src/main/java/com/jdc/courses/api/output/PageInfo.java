package com.jdc.courses.api.output;

import java.util.ArrayList;
import java.util.List;

public record PageInfo(
		int page,
		int size,
		int totalCount) {
	
	public int getTotalPage() {
		var rem = totalCount % size;
		var pages = totalCount / size;
		return rem == 0 ? pages : pages + 1; 
	}

	public List<Integer> getLinks() {
		var links = new ArrayList<Integer>();
		
		links.add(page);
		var totalPage = getTotalPage();
		
		while(links.size() < 3 && links.getFirst() > 0) {
			links.addFirst(links.getFirst() - 1);
		}
		
		while(links.size() < 5 && links.getLast() < totalPage - 1) {
			links.addLast(links.getLast() + 1);
		}
		
		while(links.size() < 5 && links.getFirst() > 0) {
			links.addFirst(links.getFirst() - 1);
		}
		
		return links;
	}
}
