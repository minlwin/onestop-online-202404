package com.jdc.bot.model;

import java.util.Arrays;

public interface Dictionary {

	String search(String question);
	void register(Conversation conversation);

	public static Dictionary getInstance() {
		return new HashFunctionDictionary();
	}
}

class HashFunctionDictionary implements Dictionary {

	private String[] data = {};

	public String search(String question) {

		if(data.length > question.hashCode()) {
			return data[question.hashCode()];
		}

		return null;
	}

	public void register(Conversation conversation) {
		var index = conversation.question().hashCode();

		if(data.length < index + 1) {
			data = Arrays.copyOf(data, index + 1);
		}

		data[index] = conversation.answer();
	}

}

class UnlimittedArrayDictionary implements Dictionary {

	private Conversation[] conversations = {};

	public String search(String question) {

		for(var conversation : conversations) {
			if(conversation.question().equalsIgnoreCase(question)) {
				return conversation.answer();
			}
		}

		return null;
	}

	public void register(Conversation conversation) {
		conversations = Arrays.copyOf(conversations, conversations.length + 1);
		conversations[conversations.length - 1] = conversation;
	}
}