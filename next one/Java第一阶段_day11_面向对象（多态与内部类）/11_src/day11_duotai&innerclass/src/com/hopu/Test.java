package com.hopu;
public class Test { 
    public static void main(String[] args) { 
        // ��̬��ʽ���������� 
        Animal a1 = new Cat(); 
        // ���õ��� Cat �� eat 
        a1.eat(); 
        System.out.println(a1.a);
        // ��̬��ʽ���������� 
        Animal a2 = new Dog(); 
        // ���õ��� Dog �� eat 
        a2.eat(); 
    }
}