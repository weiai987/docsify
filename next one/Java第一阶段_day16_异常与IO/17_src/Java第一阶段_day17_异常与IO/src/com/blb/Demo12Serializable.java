package com.blb;

import java.io.*;

class Person implements Serializable {
//  序列化版本号，必须保证序列化跟反序列化的版本号一致
    private static final long serialVersionUID = -1213754818242979380L;

    public String name   ;
    //设置age字段为transient，表示此字段不需要序列化
    public  transient int age = 1 ;

    public String sex ;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }
}


public class Demo12Serializable {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        saveObject();// 序列化
        readObject();// 反序列化

    }

//  序列化
    public static void saveObject() throws IOException{
//        准备要序列化的对象
        Person person = new Person();
        person.name = "张三";
        person.age = 18 ;
        person.sex = "男";
//      准备对象流
        FileOutputStream fos = new FileOutputStream("d:/blb.txt");
        ObjectOutputStream out = new ObjectOutputStream(fos);
//      序列化对象
        out.writeObject(person);
//      关闭流
        out.close();
        fos.close();
    }

//    反序列化
    public  static void readObject() throws IOException, ClassNotFoundException {
        //      准备对象流
        FileInputStream fis = new FileInputStream("d:/blb.txt");
        ObjectInputStream in = new ObjectInputStream(fis);
        //      反序列化对象
        Person person = (Person) in.readObject();
        System.out.println(person);
        //      关闭流
        in.close();
        fis.close();
    }

}
