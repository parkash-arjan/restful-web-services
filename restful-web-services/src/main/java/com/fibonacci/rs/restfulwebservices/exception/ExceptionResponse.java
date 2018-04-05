package com.fibonacci.rs.restfulwebservices.exception;

import java.util.Date;

public class ExceptionResponse {

	private Date timestamp;
	private String message;
	private String deatils;

	public ExceptionResponse(Date timestamp, String message, String deatils) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.deatils = deatils;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDeatils() {
		return deatils;
	}

	public void setDeatils(String deatils) {
		this.deatils = deatils;
	}

}
