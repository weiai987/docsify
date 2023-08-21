package com.blb;

import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Demo04Lambda {

    public static void main(String[] args) {
//       随机产生一个整数
        Supplier<Integer> supplier = ()->{
          return new Random().nextInt();
        };

        Integer result = supplier.get();
        System.out.println("随机产生一个整数： "+result);

//      小写字符串转成大写字符串
        Consumer<String> consumer = (s)->{
            System.out.println(s.toUpperCase());
        };
        consumer.accept("hello blb!");

//       将字符串转成数字
        Function<String,Integer> function = (s)->{
            return Integer.parseInt(s);
        };
        System.out.println(function.apply("123"));

//      判断一个整数是否是偶数
        Predicate<Integer> predicate = (i)->{
            return i%2==0;
        };
        System.out.println("是否是整数："+predicate.test(18));
    }
}
