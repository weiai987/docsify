package com.blb;

import java.util.TreeSet;

public class Demo05TreeSet {

    public static void main(String[] args) {
        TreeSet<Person> treeSet = new TreeSet<>();
        treeSet.add(new Person("刘备",33));
        treeSet.add(new Person("关羽",23));
        treeSet.add(new Person("张飞",27));
    }

}

class Person implements  Comparable<Person>{

    private String name ;
    private int age ;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Person person) {
        return this.age - person.age;
    }
}
