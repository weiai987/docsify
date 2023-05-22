package com.hopu.demo.extend;

class Fu { 
	public void show() { 
		System.out.println("Fu show"); 
	} 
}

class Zi extends Fu { 	
	public void show(int b) { 
		System.out.println("Zi show "+b); 
	} 
}

public class ExtendsDemo2 { 
	public static void main(String[] args) { 
		
		// 创建子类对象 
		Zi z = new Zi(); 
		// 子类中有show方法，只执行重写后的show方法
		z.show(1); 
		
	} 
}

