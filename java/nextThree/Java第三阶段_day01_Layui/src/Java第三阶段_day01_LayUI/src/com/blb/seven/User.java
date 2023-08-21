package com.blb.seven;


public class User {
	
	private String name = "" ;
	
	private String password = "" ;
	
	private Integer id = 0 ;
	
	public User(String name, String password, Integer id) {
		super();
		this.name = name;
		this.password = password;
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
