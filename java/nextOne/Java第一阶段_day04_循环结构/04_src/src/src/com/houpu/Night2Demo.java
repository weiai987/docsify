package com.houpu;

public class Night2Demo {
	public static void main(String[] args) {
		// ����:ʵ��һ���žų˷���
		// ���forѭ�����������ǵ�����
		for(int i=1;i<=9;i++) {
			// i=2
			for(int j=1 ;j<=i ; j++) {
				// �ַ���ƴ��		1x1=1
				//                 2x1=2 
				//                 2x2=4 
				// ת���
				System.out.print(j+"x"+i+"="+i*j+"\t");	
			}
			// ����ÿһ�е��ڲ�forѭ����ɺ���л���
			System.out.println();
		}
	}
}
