package com.zuoye;


interface Inter {
    void show();
}
class Outer {
	//²¹Æë´úÂë	
	public static Inter method = new Inter() {
		@Override
		public void show() {
			System.out.println("HelloWorld");		
		}		
	};  
}
public class Test {
    public static void main(String[] args) {
//          Outer.method().show();
          Outer.method.show();
     }
}