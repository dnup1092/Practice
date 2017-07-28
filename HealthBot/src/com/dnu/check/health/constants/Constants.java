package com.dnu.check.health.constants;

public enum Constants {

	CONTEXTCONFIG("abilityConfig"),
	STRATEGIES("strategies"),
	CONNECTION("connection"),
	DRIVER("driver"),
	USERNAME("username"),
	PASSWORD("password"),
	PACKAGES("packages"),
	PACKAGE("package"),
	PROPERTY("property");
	
	private String value;
	
	private Constants(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
	
	public static final String LITERAL_DRIVER = "driver";
	public static final String LITERAL_USERNAME = "username";
	public static final String LITERAL_PASSWORD = "password";
	
}
