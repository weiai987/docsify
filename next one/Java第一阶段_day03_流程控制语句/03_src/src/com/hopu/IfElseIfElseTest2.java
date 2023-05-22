package com.hopu;

import java.util.Scanner;

public class IfElseIfElseTest2 {

	public static void main(String[] args) {

	    //小明的考试成绩未知，可以使用键盘录入的方式获取值
	    Scanner sc = new Scanner(System.in);
	    System.out.println("请输入一个分数：");
	    int score = sc.nextInt();
	    //由于奖励种类较多，属于多种判断，采用if...else if...else格式实现
	    //为每种判断设置对应的条件
	    //为每种判断设置对应的奖励
	    //数据测试：正确数据，边界数据，错误数据
	    if(score>100 || score<0) {
	    	System.out.println("你输入的分数有误");
	    	//  95 =<score <=100
	    } else if(score>=95 && score<=100) {
	    	System.out.println("山地自行车一辆");
	    } else if(score>=90 && score<=94) {
	    	System.out.println("游乐场玩一次");
	    } else if(score>=80 && score<=89) {
	    	System.out.println("变形金刚玩具一个");
	    } else {
	    	System.out.println("胖揍一顿");
	    }
	}
}