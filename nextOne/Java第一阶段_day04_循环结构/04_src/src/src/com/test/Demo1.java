package com.test;

import java.util.Random;
import java.util.Scanner;

public class Demo1 {
	public static void main(String[] args) {
		// ��ȭ 1:���� 2��ʯͷ 3����		
		Random random = new Random();
		// ��������
		int pcnum = random.nextInt(3)+1;
		System.out.println(pcnum);
		
		// �˲�
		Scanner scanner = new Scanner(System.in);
		
		while(true) {
			System.out.println("���������µ�����");
			int mynum = scanner.nextInt();
			// �ж�
			// ����һ��
			if(pcnum==mynum) {
				System.out.println("ƽ�֣�");
			}else if(pcnum==1 && mynum==2 || pcnum==2&& mynum==3 || pcnum==3&&mynum==1) {
				// ��Ӯ�ĳ���
				System.out.println("��ϲ����Ӯ��");
				break;
			}else {
				// ����Ӯ�ĳ���	
				System.out.println("������");
				break;
			}
		}
		
		
		
//		// ��������
//		if(pcnum==mynum) {
//			System.out.println("ƽ�֣�");
//		}else if(mynum-pcnum==1 || mynum-pcnum==-2) {
//			// ��Ӯ�ĳ���
//			System.out.println("��ϲ����Ӯ��");
//		}else {
//			// ����Ӯ�ĳ���	
//			System.out.println("������");
//		}
		
	}

}
