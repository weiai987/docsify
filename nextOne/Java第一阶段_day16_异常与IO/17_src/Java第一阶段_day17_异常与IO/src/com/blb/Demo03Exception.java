package com.blb;

public class Demo03Exception {

    public static void main(String[] args) {
        try {
//            制造一个异常。
            System.out.println(5/0);
            String s = null;
            System.out.println(s.toString());
        }catch (ArithmeticException e){
            System.out.println("发生了算术运算的异常。");
            e.printStackTrace();
        }catch (NullPointerException e){
            System.out.println("发生了空指针的异常。");
            e.printStackTrace();
        }
    }
}
