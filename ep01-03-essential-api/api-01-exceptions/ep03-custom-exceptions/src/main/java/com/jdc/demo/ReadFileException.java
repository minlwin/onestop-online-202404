package com.jdc.demo;

public class ReadFileException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	private Level level;
	
	public ReadFileException(Level level, String message, Throwable cause) {
		super(message, cause);
		this.level = level;
	}

	public ReadFileException(Level level, String message) {
		super(message);
		this.level = level;
	}
	
	public ReadFileException(String message) {
		super(message);
		this.level = Level.Error;
	}

	public Level getLevel() {
		return level;
	}
	
	public enum Level {
		Info, Warning, Error
	}
}
