package com.blb;

import java.util.HashMap;
import java.util.Objects;

class Hero{

    private String name ;

    public Hero(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Hero)) return false;
        Hero hero = (Hero) o;
        return Objects.equals(name, hero.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Hero{" +
                "name='" + name + '\'' +
                '}';
    }
}

public class Demo08HashMap {

    public static void main(String[] args) {
        //创建 map对象
        HashMap<Hero, String> map = new HashMap<Hero, String>();

        //添加元素到集合
        map.put(new Hero("关羽"), "樊城");
        map.put(new Hero("张飞"), "新野");
        map.put(new Hero("赵子龙"), "徐州");
        map.put(new Hero("刘备"), "荆州");
        map.put(new Hero("刘备"), "荆州");
        System.out.println(map);

    }
}
