package com.restfull.webservice.restfullwebservice.bean;

public class HelloWorld {
	
	private String message;

	
	protected HelloWorld() {
		
	}
	
	public HelloWorld(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	

}
