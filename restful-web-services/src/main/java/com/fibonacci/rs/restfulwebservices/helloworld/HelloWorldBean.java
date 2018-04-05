package com.fibonacci.rs.restfulwebservices.helloworld;

public class HelloWorldBean {
	private String message;

	protected HelloWorldBean() {

	}

	public HelloWorldBean(String message) {
		this.setMessage(message);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
