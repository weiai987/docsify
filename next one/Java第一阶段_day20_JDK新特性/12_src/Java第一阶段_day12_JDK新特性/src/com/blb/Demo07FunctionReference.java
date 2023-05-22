package com.blb;

import java.util.function.Consumer;

public class Demo07FunctionReference {

    public static void main(String[] args) {
//  选择合适的函数接口，使它拥有跟System.out对象的println方法一样的功能。
        Consumer<String> consumer = System.out::println;
        consumer.accept("斗转星移");
    }
}
