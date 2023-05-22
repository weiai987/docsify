package com.hopu.parctice;

public class PeachTest {
	public static void main(String[] args) {
		forTest();
		
		whileTest();
		
		System.out.println(recursiveTest(10,1));
	}
	// 1、使用for循环实现
	public static void forTest() {
       int cur = 1;            // 当前第10天 剩1个
       for(int day = 9;day >=1; day--){
    	   cur = (1+cur)*2;   
       }
       System.out.println(cur);

	}
	// 2、使用while循环实现
	public static void whileTest() {
       int cur = 1;   // 第10天 剩1个
       int day = 9;
       while(day > 0){
    	   cur = (1+cur)*2;  
           day--;
       }
       System.out.println(cur);
	}
	// 3、使用递归方法实现
    public static int recursiveTest(int day,int total){
    	if(day==1) {
    		return total;
    	}else {
    		total=(total+1)*2;
    		return recursiveTest(--day,total);
    	}
    }
}
