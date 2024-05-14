package com.jdc.bot.model.impl;

public class DictionarySeparate extends AbstractDictionary{

	private Node[] nodes;
	
	public DictionarySeparate() {
		capacity = 97;
		nodes = new Node[capacity];
	}

	@Override
	public int register(String question, String answer) {
		var hash = hash(question);
		var node = nodes[hash];
		
		if(null == node) {
			node = new Node(new Entry(question, answer));
			nodes[hash] = node;
			return ++ size;
		}
		
		if(!node.update(question, answer)) {
			var newNode = new Node(new Entry(question, answer));
			newNode.next = node;
			nodes[hash] = newNode;
			return ++ size;
		}
		
		return size;
	}

	@Override
	public String search(String question) {
		
		var hash = hash(question);
		var node = nodes[hash];
		
		if(null != node) {
			return node.find(question);
		}
		
		return null;
	}

	private static class Node {
		Entry data;
		Node next;
		
		Node(Entry data) {
			super();
			this.data = data;
		}
		
		boolean update(String question, String answer) {
			if(data.question().equals(question)) {
				data = new Entry(question, answer);
				return true;
			}
			
			if(null != next) {
				return next.update(question, answer);
			}

			return false;
		}
		
		String find(String question) {
			if(data.question().equals(question)) {
				return data.answer();
			}
			
			if(null != next) {
				return next.find(question);
			}
			
			return null;
		}
	}
}
