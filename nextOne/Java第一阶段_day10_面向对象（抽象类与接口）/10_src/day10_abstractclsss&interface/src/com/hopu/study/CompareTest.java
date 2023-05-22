package com.hopu.study;

import java.util.Arrays;
import java.util.Comparator;
// 学生类
class Student implements Comparable<Student> {
	private String name;
	private int age;
	public Student() {
	}
	public Student(String name, int age) {
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
		return "Student [name=" + name + ", age=" + age + "]";
	}
	@Override
	public int compareTo(Student o) {
		return this.age - o.age;
	}
}
// 自定义比较器类
class MyComparator implements Comparator<Student> {
    @Override
    public int compare(Student o1, Student o2) {
        return o1.getName().charAt(0)-o2.getName().charAt(0);
    }
}
// 测试类
public class CompareTest {
	public static void main(String[] args) {
		// 初始化学生类数组
		Student[] str=new Student[5];
		str[0]=new Student("tom",22);
		str[1]=new Student("kitty",18);
		str[2]=new Student("Jacklove",23);
		str[3]=new Student("uzi",23);
		str[4]=new Student("tom",17);
		// 打印原生数组
		System.out.println(Arrays.toString(str));		
		// 使用比较器默认排序
		Arrays.sort(str);
		// 排序后再次打印
		System.out.println(Arrays.toString(str));
		// 使用比较器排序
		Arrays.sort(str, new MyComparator());
		// 排序后再次打印
		System.out.println(Arrays.toString(str));
	}
}	
