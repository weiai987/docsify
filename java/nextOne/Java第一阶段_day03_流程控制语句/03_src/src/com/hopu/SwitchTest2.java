package com.hopu;

public class SwitchTest2 {

	public static void main(String[] args) {
		int month=4;
		
		switch(month) {
			case 12:
			case 1:				
			case 2:
				System.out.println("����");
				break;
				
			case 3:
			case 4:
			case 5:
				System.out.println("����");
				break;
				
			case 6:
			case 7:
			case 8:
				System.out.println("�ļ�");
				break;
				
			case 9:
			case 10:
			case 11:
				System.out.println("�＾");
				break;
				
			default:
				System.out.println("�·�����");
				break;
		}
	}

}
