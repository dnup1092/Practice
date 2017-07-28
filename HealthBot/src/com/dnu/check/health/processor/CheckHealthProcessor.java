package com.dnu.check.health.processor;

public abstract class CheckHealthProcessor {
	private boolean LevelStatus;
	
	abstract boolean requestProcessor();
	
	public void tearDown() {
		
	}
}
