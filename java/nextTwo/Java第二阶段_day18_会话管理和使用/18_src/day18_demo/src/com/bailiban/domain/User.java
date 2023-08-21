package com.bailiban.domain;

import java.util.Date;

public class User {
	
	private String name;
	private int age;
	private Date birthday;
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public User(String name, int age, Date birthday) {
		super();
		this.name = name;
		this.age = age;
		this.birthday = birthday;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	
}
