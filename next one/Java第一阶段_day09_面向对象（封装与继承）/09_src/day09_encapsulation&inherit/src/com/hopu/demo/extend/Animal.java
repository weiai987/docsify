package com.hopu.demo.extend;

public class Animal {
	private String name; 
	
	public void run() {
		System.out.println("动物在奔跑");
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}	 
}
