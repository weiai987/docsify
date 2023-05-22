package com.blb;

public class CommonClassObject {

    public static void main(String[] args) throws Exception {
        Person p1 = new Person("张三",12);
        Person p2 = new Person("李四",15);
        System.out.println(p1 == p2);
        System.out.println(p1.equals(p2));
        System.out.println(p1.toString());

        Person p3 = (Person) p1.clone();
        System.out.println(p1.equals(p3.toString()));
    }


}

class Person implements Cloneable {

    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
//        如果要比较的2个对象是同一个对象，则直接返回true
        if (this == o) return true;
//        如果要比较的2个对象的类型不一致，则直接返回false
        if (!(o instanceof Person)) return false;
//        将要比较的对象转成当前类型，并比较姓名是否相同
        Person person = (Person) o;
        return name.equals(person.name);
    }

    @Override
    public String toString() {
        return "Person{" + "name='" + name + '\'' + ", age=" + age + '}';
    }

    // 访问权限提升为public，逻辑使用父类的逻辑即可。
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}
