package com.houpu;

public class WhileDemo1 {
	public static void main(String[] args) {
		//�����������ɽ�������������(8844.43��=8844430����)����������һ���㹻���ֽ�����ĺ����0.1���ס����ʣ����۵����ٴΣ������۳����������ĸ߶�?
//		int num=0;
//		for( double i=0.1; i<=8844430; i*=2) {
//			// 0.1 0.2 0.4 0.8 1.6
//			num++;
//		}
//		System.out.println(num);
		
		int num=0; // �������۵�����
		double zt=0.1;
		while(zt<=8844430) {
			num++;
			zt*=2;
		}
		System.out.println(num);
	}
}
