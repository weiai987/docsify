package com.hopu;
public class Sun extends Father{
	String str = "sun";
	public void say() {
		System.out.println("ÎÒÊÇ¶ù×Ó");
	}
	
	public static void main(String[] args) {
//		Sun sun = new Sun();
//		Father father = new Father();
//		sun.say();
//		father.say();
		
		Father father = new Sun();
	    father.say();
	    
	    System.out.println(father.str);
	}
}