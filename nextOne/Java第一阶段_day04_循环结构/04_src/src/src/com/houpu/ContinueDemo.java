package com.houpu;

public class ContinueDemo {
	public static void main(String[] args) {
		// ���󣺴�ӡ1~10֮��Ļ���
		
		for(int i=1 ;i<=10 ;i++ ) {
			
			// �����ż����������ǰѭ����������һ��ѭ��
			if(i%2==0) {
				
				continue;
//				System.out.println(i);
			}
			System.out.println(i);
			
		}
	}
}
