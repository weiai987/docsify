package com.hopu;

import java.util.Scanner;

public class IfElseIfElseTest {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("��������������1~7����");
		int day = scanner.nextInt();
		

//		System.out.println(day);
		if(day==1) {
			System.out.println("����һ");
		}else if(day==2) {
			System.out.println("���ڶ�");
		}else if(day==3) {
			System.out.println("������");	
		}else if(day==4) {
			System.out.println("������");
		}else if(day==5) {
			System.out.println("������");
		}else if(day==6) {
			System.out.println("������");
		}else if(day==7) {
			System.out.println("������");
		}else {
			System.out.println("������������");
		}
	}

}
