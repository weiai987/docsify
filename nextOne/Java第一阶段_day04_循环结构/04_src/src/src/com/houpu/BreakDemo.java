package com.houpu;

public class BreakDemo {
	public static void main(String[] args) {
		// ���󣺻�ȡ��һ��ˮ�ɻ���
		// �ڿ���̨������еġ�ˮ�ɻ�����
		
		
		
		
		for(int i=100 ; i<1000 ; i++) {
			// ����i=123;
			int ge=i%100%10;
			
			int shi= i/10%10;
		
			int bai= i/100;
			
			// ����ÿ��λ�ϵ����ֵ� 3����֮�͵���������
			if(ge*ge*ge+shi*shi*shi+bai*bai*bai==i) {
				System.out.println(i);
				
				break;
			}	
		}
	}
}
