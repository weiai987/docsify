package com.test;

import java.util.Random;
import java.util.Scanner;

public class Demo3 {

	public static void main(String[] args) {
		// ��ȭ��1������ 2��ʯͷ 3����
		// �õ������
		

		// ���˲�
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			Random random = new Random();
			int pcnum = random.nextInt(3)+1;
			System.out.println(pcnum);
			
			System.out.println("���ȭ��");
			int mynum = scanner.nextInt();
			
			// �Ա�
			if(mynum==pcnum) {
				System.out.println("ƽ��");
			}else if(mynum-pcnum==1 ||  mynum-pcnum==-2) {
				// ��Ӯ�����
				System.out.println("��ϲ������Ӯ��");
				break;
			}else {
				// ����Ӯ�����
				System.out.println("������");
				break;
			}
		}
		
		
	}

}
