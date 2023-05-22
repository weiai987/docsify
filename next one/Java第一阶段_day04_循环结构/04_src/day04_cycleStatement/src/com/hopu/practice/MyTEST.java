package com.hopu.practice;

import java.util.Scanner;

public class MyTEST {
	public static void main(String[] args) {
        for(int i=1;i<=1000;i++) {
            int t = 0;
            for(int j=1;j<=i/2;j++) {
                if(i%j==0) {
                    t+=j;
                }
            }
            if(t==i) {
                System.out.println(i);
            }
        }
    }


}
