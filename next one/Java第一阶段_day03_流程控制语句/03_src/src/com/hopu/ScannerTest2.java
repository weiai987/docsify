package com.hopu;

import java.util.Scanner;

public class ScannerTest2 {

	public static void main(String[] args) {
		// ����¼������ѧԱ�ĳɼ�90�֡�94�֡�82�֣�Ȼ��ʹ����������бȽϻ�ȡ�ɼ���ߵķ�������ӡ���
		// 1������Scanner����
		Scanner scanner = new Scanner(System.in);
		
		// 2����ʼ�����û�¼���ѧԱ�ɼ�
		System.out.println("�������һ��ѧ���ĳɼ���");
		int score1 = scanner.nextInt();

		System.out.println("������ڶ���ѧ���ĳɼ���");
		int score2 = scanner.nextInt();
		
		System.out.println("�����������ѧ���ĳɼ���");
		int score3 = scanner.nextInt();
		
//		System.out.println(score1);
//		System.out.println(score2);
//		System.out.println(score3);
		
		// 3����ȡ��߷�  (�����Ƚ�)
		int temp=score1 > score2? score1:score2;
		
		int max = temp > score3? temp:score3;
		
		System.out.println("��߷�Ϊ��"+max);
	}

}
