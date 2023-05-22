package com.houpu;

public class Demo2 {

	public static void main(String[] args) {
		//使用嵌套循环，打印2021年至2023年月份，格式：xxxx年x月
		// 2021年1月
		// 2021年2月
		// 2021年3月
		// 2021年12月
		// 2022年1月
		// 外层循环控制年份
		// 一旦遇到10月，跳出整个循环
		// break跳出当前循环
		aaaa:for(int year=2021;year<=2023;year++) {
			// 内部循环控制月份
			for(int month=1;month<=12;month++) {
				if(month==10) {
//					break;
//					break aaaa;
					
					continue aaaa;
				}
				System.out.println(year+"年"+month+"月");
			}
		}
		
	}

}
