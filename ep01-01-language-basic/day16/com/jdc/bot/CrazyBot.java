package com.jdc.bot;

import com.jdc.bot.model.*;

public class CrazyBot {

	private Dictionary dictionary;
	private String lastQuestion;

	public CrazyBot() {
		dictionary = Dictionary.getInstance();
	}

	public String talk(String message) {

		if(null != lastQuestion) {
			// Teaching to bot
			dictionary.register(new Conversation(lastQuestion, message));
			lastQuestion = null;
			return "Thank you";
		}

		var answer = dictionary.search(message);

		if(null == answer) {
			lastQuestion = message;
			return "I've no idea, please teach me";
		}

		return answer;
	}
}