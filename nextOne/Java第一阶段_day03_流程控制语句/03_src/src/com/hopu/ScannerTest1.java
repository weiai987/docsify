package com.hopu;
// 1������
//import java.util.Scanner;

import java.util.Scanner;

public class ScannerTest1 {
	public static void main(String[] args) {
		//2����������
//		Scanner sc=new Scanner(System.in);
		Scanner scanner = new Scanner(System.in);
		
		// ������ʾ
		System.out.println("������һ��������");
		// 3����ȡ��������
		int num = scanner.nextInt();
		
		System.out.println("���յ��������ǣ�"+num);
	}

}
