package com.hopu;

import java.util.Scanner;

public class IfElseIfElseTest2 {

	public static void main(String[] args) {

	    //С���Ŀ��Գɼ�δ֪������ʹ�ü���¼��ķ�ʽ��ȡֵ
	    Scanner sc = new Scanner(System.in);
	    System.out.println("������һ��������");
	    int score = sc.nextInt();
	    //���ڽ�������϶࣬���ڶ����жϣ�����if...else if...else��ʽʵ��
	    //Ϊÿ���ж����ö�Ӧ������
	    //Ϊÿ���ж����ö�Ӧ�Ľ���
	    //���ݲ��ԣ���ȷ���ݣ��߽����ݣ���������
	    if(score>100 || score<0) {
	    	System.out.println("������ķ�������");
	    	//  95 =<score <=100
	    } else if(score>=95 && score<=100) {
	    	System.out.println("ɽ�����г�һ��");
	    } else if(score>=90 && score<=94) {
	    	System.out.println("���ֳ���һ��");
	    } else if(score>=80 && score<=89) {
	    	System.out.println("���ν�����һ��");
	    } else {
	    	System.out.println("����һ��");
	    }
	}
}