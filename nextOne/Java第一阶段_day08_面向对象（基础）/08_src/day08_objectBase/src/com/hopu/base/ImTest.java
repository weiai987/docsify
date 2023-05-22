package com.hopu.base;

//import com.hopu.base.zi.Car1;
//import com.hopu.base.zi.Car2;
import com.hopu.base.zi.*;
import com.hopu.test.User;

public class ImTest {
	public static void main(String[] args) {
		// 1、java.lang包下的类，可以无需import引入
		String str="abc";
		
		// 2、同包下的其他类，可以无需import引入
		Student stu=new Student();
		
		// 3、其他非特殊包下的类，必须使用import关键字引入
		User user=new User();
		
		// 4、引入其他包下的多个类，可以使用通配符“*”引入所有包下所有类
		Car1 c1= new Car1();
		Car2 c2= new Car2();
		
		System.out.println(19/10);
	}
}
