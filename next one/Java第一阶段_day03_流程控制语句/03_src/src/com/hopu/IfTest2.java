package com.hopu;

import java.util.Scanner;

public class IfTest2 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("����С���ĳɼ���");
		int score = scanner.nextInt();
		
		if(score>700) {
			// ����������ʱ��ִ�е�
			System.out.println("�����Ϲ���");
		}else {
			// ������������ʱ��ִ��
			System.out.println("��שȥ");
		}
		
	}

}
