package com.micro.demo.MicroService_Demo.bean;

public class HelloWorld {

	private String message;
	
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
