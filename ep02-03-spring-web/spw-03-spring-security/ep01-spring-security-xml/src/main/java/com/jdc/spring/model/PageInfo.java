package com.jdc.spring.model;

import java.util.ArrayList;
import java.util.List;

public record PageInfo<T>(
		List<T> contents,
		int page,
		int size,
		long count) {

	public long totalPage() {
		var pages = count / size;
		return count % size == 0 ? pages : pages + 1;
	}
	
	public boolean showFirst() {
		return page > 0;
	}
	
	public boolean showLast() {
		return links().getLast() < totalPage() - 1;
	}
	
	public List<Integer> links() {
		var links = new ArrayList<Integer>();
		
		links.add(page);
		
		while(links.getFirst() > 0 && links.size() < 3) {
			links.addFirst(links.getFirst() - 1);
		}
		
		while((links.getLast() < totalPage() - 1) && links.size() < 5) {
			links.add(links.getLast() + 1);
		}
		
		while(links.getFirst() > 0 && links.size() < 5) {
			links.addFirst(links.getFirst() - 1);
		}

		return links;
	}
}
