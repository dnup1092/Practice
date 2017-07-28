package com.dnu.check.health.exceptions;

@SuppressWarnings("serial")
public class GenericException extends RuntimeException {
	
	public GenericException(String message) {
		super(message);
	}
	
	public GenericException(String message, Exception e) {
		super(message,e.getCause());
	}
}
