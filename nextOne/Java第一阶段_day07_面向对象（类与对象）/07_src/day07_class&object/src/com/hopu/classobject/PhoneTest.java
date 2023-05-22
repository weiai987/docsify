package com.hopu.classobject;
public class PhoneTest {
  public static void main(String[] args) {
    //创建对象
    Phone p = new Phone();

    //输出成员变量值
    System.out.println("品牌："+p.brand);//null
    System.out.println("价格："+p.price);//0
    System.out.println("颜色："+p.color);//null
    System.out.println("------------");

    //给成员变量赋值
    p.brand = "锤子";
    p.price = 2999;
    p.color = "棕色";

    //再次输出成员变量值
    System.out.println("品牌："+p.brand);//锤子
    System.out.println("价格："+p.price);//2999
    System.out.println("颜色："+p.color);//棕色
    System.out.println("------------");

    //调用成员方法
    p.call("紫霞");
    p.sendMessage();
  }
}