package com.blb;

import org.junit.Test;

enum Genders {
    MALE , FEMALE ;
}

public class Demo08Enum {

    @Test
    public void testEnum01(){
        Genders person = Genders.MALE ;
        System.out.println(person);
    }

    @Test
    public void testEnum02(){
        Genders person = Genders.FEMALE ;
        System.out.println(person.name());//FEMALE
        System.out.println(person.ordinal());//1

        Genders p1 = Enum.valueOf(Genders.class, "MALE");
        System.out.println(p1.name());//MALE
        System.out.println(p1.ordinal());//0
    }
}
