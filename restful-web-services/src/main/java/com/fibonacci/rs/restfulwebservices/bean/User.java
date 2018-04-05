package com.fibonacci.rs.restfulwebservices.bean;

import java.util.Date;

public class User {

	private Long id;
	private String name;
	private Date date;

	protected User() {

	}

	public User(Long id, String name, Date date) {
		this.id = id;
		this.name = name;
		this.date = date;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return String.format("User [id=%s, name=%s, date=%s]", id, name, date);
	}

}
