package com.hopu.classobject;
public class Phone {
  // 成员变量
  String brand; //品牌
  int price; //价格
  String color; //颜色

  // 成员方法
  //打电话
  public void call(String name) {
    System.out.println("给"+name+"打电话");
  }

  //发短信
  public void sendMessage() {
    System.out.println("群发短信");
  }
}