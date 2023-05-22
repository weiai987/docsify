package com.blb;

import java.lang.annotation.*;

//   重复注解
@MyAnnotation("hello")
@MyAnnotation("world")
public class Demo12Annotation {

    public static void main(String[] args) {
        MyAnnotation[] annotations = Demo12.class.getAnnotationsByType(MyAnnotation.class);
        for (MyAnnotation anno : annotations){
            System.out.println(anno.value());
        }

    }
}

//定义注解容器
@Target({ElementType.FIELD,ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotations{
    MyAnnotation [] value() ;
}

// 定义注解内容
@Target({ElementType.FIELD,ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(MyAnnotations.class)
@interface MyAnnotation{
    String  value() default  "blb" ;
}
