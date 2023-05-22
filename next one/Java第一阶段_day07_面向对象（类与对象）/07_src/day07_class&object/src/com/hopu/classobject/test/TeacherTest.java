package com.hopu.classobject.test;

public class TeacherTest {
	// 定义main方法程序入口
	public static void main(String[] args) {
		// 创建Teacher类对象
		Teacher t= new Teacher();
		// 调用普通方法
		t.run("孔子", 3000);
		
		// 调用静态方法
		Teacher.teach();
	}
}
