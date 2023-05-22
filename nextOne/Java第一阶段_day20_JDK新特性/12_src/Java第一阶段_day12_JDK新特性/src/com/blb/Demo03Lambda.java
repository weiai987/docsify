package com.blb;

public class Demo03Lambda {

    public static void main(String[] args) {
        Eatable eatable = (food)->{
            System.out.println("大口的吃"+food);
            return "吃饱了";
        };

        String result = eatable.eat("牛肉");
        System.out.println(result);

    }
}

@FunctionalInterface
interface Eatable{
    String eat(String food);
}
