package com.houpu;

public class ForDemo2 {

	public static void main(String[] args) {
//		// �ڿ���̨���1-5��5-1������
//		for(int i=1; i<=5; i++) {
//			System.out.println(i);
//		}
//		System.out.println("========================");
//		for(int i=5; i>0 ; i--) {
//			System.out.println(i);
//		}
//		
//		
//		// ��չ�����1~20֮��1��4��7��10��13��16��������
//		for(int i=1 ; i<=20 ; i+=3) {
//			System.out.println(i);
//		}
		
		// ���� ��1~100֮������ݺͣ�������ͽ���ڿ���̨���
		// 1 +2 + 3 + 4+ ...... +100
		// 100+ǰ99�����ĺ�
		// 99�����ĺ�=====99+ǰ98�����ĺ�
		// 2�����ĺ�======2+ǰ1�����ĺ�  2+1
		// 1�����ĺ�=======1+ǰ��0�����ĺ�
		int sum=0;  // ����һ��������¼ǰ�����ݵĺ�
		for(int i=1; i<=100 ;i++ ) {
			// iֻ�Ǵ���ǰѭ�������е����ִ�С
			System.out.println(i);
			// sum= 1+0
			// sum=2+1
//			sum=i+sum;
			 
			sum+=i;
		}
		System.out.println(sum);
		
	
		
		
	}

}
