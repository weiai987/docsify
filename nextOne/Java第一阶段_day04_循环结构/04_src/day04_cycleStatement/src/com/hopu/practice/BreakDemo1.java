package com.hopu.practice;

public class BreakDemo1 {
	public static void main(String[] args) {
	    for (int i = 1; i<=10; i++) {
	       
	        if(i % 3 == 0){
	          //分别单独打开注释执行，看执行结果
	          //break;  
	          //continue; 
	        }
	        System.out.println("i= "+i);
	    }
	}
}
