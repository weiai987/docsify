package com.blb;

public class Demo01String {

    public static void main(String[] args) {
        String name =new String("haley") ;
        System.out.println(name.length()); //长度为5

        System.out.println(name.equals("Haley")); //false
        System.out.println(name.equalsIgnoreCase("Haley")); //true

        System.out.println(name.toLowerCase()); //haley
        System.out.println(name.toUpperCase()); //HALEY

        System.out.println(name.concat("helay")); //hello helay
        System.out.println("hello "+"helay"); //hello helay

        String word ="hello , welcome to bailiban! ";
        //            返回字符97第一次出现的位置
        System.out.println(word.indexOf(97)); //20
        //            返回字符串ba第一次出现的位置
        System.out.println(word.indexOf("ba")); //19
        //            返回字符97最后一次出现的位置
        System.out.println(word.lastIndexOf(97)); //25
        //            返回字符串ba最后一次出现的位置
        System.out.println(word.lastIndexOf("ba")); //24

    }


}
