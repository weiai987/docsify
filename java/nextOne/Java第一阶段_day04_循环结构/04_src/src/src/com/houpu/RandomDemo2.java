package com.houpu;

import java.util.Random;
import java.util.Scanner;

public class RandomDemo2 {

	public static void main(String[] args) {
		/*
		 * - **����**�����Զ�����һ��1-100֮������֣�ʹ�ó���ʵ�ֲ³���������Ƕ��٣�49
		 * 
		 * ����**�����Զ�����һ��37~79֮������֣�ʹ�ó���ʵ�ֲ³���������Ƕ��٣�49
		 * 
		 * - **Ч����** 
		 * - ����µ����ֱ���ʵ���ִ���ʾ��µ����ݴ��� 
		 * - ����µ����ֱ���ʵ����С����ʾ��µ�����С��
		 *  - ����µ���������ʵ������ȣ���ʾ��ϲ�������
		 */
		// �������������
		Random random = new Random();
		// ����һ�������
		int num = random.nextInt(100)+1;
		Scanner scanner = new Scanner(System.in);
		
		while(true) {			
			// �ظ��µ�����
			System.out.println("���һ��1~100�����֣�");
			int cai = scanner.nextInt();
			
			if(cai>num) {
				System.out.println("��µ����ݴ���");
			}else if(cai<num) {
				System.out.println("��µ�����С��");
			}else {
				// ������ȣ����ǲ�����
				System.out.println("��ϲ�������");
				
				break;  // �Ѿ����У�û�б�Ҫ�ظ�����
			}	
		}
		System.out.println("game over");
	}

}
