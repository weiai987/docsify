package com.blb;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

// 修饰泛型类
public class Demo13Annotation< @TypeParam T> {
//   在任意使用类型的地方使用，包括基本数据类型
    public @TypeUse  int i = 1 ;

    // 修饰泛型方法
    public < @TypeParam E> void testTypeParameter(){
        //   在任意使用类型的地方使用，包括局部变量
        @TypeUse int i ;
    }
}

//定义泛型为TYPE_USE
@Target(ElementType.TYPE_USE)
@interface TypeUse{
    String value() default "blb";
}

//定义泛型为TYPE_PARAMETER
@Target(ElementType.TYPE_PARAMETER)
@interface TypeParam{
    String value() default "blb";
}
