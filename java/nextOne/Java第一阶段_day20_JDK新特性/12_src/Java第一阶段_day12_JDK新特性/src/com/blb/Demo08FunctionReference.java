package com.blb;

import org.junit.Test;

import java.util.function.Consumer;
import java.util.function.Function;

public class Demo08FunctionReference {

    public static void main(String[] args) {
    }

    public void testMethod1(){
        Consumer<Object> c = System.out::println;
        c.accept("bailiban");
        c.accept(123);
    }

    public void testMethod2(){
        Function<Integer, String> function = String::valueOf ;
        System.out.println(function.apply(123));
    }

    public void testMethod3(){
        Function<String,Integer> function = String::length;
        System.out.println(function.apply("bailiban"));
    }

    @Test
    public void testMethod4(){
        Function<String,Student> function = Student::new;
        Student blb = function.apply("blb");
        System.out.println(blb);
    }

}

class Student {

    private String name ;

    public Student(String name){
        this.name = name ;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }
}
