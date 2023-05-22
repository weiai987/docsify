package com.bailiban.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Person {
	
	private String name;
	private int age;
	private String sex;
	  //@JsonIgnore // ∫ˆ¬‘∏√ Ù–‘
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
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
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	
	

}
