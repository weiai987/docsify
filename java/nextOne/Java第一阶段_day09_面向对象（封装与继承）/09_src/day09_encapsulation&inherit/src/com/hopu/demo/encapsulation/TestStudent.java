package com.hopu.demo.encapsulation;
public class TestStudent {
  public static void main(String[] args) {
    // 无参构造使用
    Student s= new Student();
    s.setName("柳岩");
    s.setAge(18);
    System.out.println(s.getName()+"---"+s.getAge());

    //带参构造使用
    Student s2= new Student("赵丽颖",18);
    System.out.println(s2.getName()+"---"+s2.getAge());
  }
}