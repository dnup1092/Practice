package com.dnu.check.health.exceptions;

public class NoAblilityConfigException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8322603199501259954L;

	public NoAblilityConfigException(String message) {
		super(message);
	}
	
	public NoAblilityConfigException(String message, Exception e) {
		super(message,e.getCause());
	}
	
}
