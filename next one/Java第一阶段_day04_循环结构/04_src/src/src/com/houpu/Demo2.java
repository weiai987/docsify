package com.houpu;

public class Demo2 {

	public static void main(String[] args) {
		//ʹ��Ƕ��ѭ������ӡ2021����2023���·ݣ���ʽ��xxxx��x��
		// 2021��1��
		// 2021��2��
		// 2021��3��
		// 2021��12��
		// 2022��1��
		// ���ѭ���������
		// һ������10�£���������ѭ��
		// break������ǰѭ��
		aaaa:for(int year=2021;year<=2023;year++) {
			// �ڲ�ѭ�������·�
			for(int month=1;month<=12;month++) {
				if(month==10) {
//					break;
//					break aaaa;
					
					continue aaaa;
				}
				System.out.println(year+"��"+month+"��");
			}
		}
		
	}

}
