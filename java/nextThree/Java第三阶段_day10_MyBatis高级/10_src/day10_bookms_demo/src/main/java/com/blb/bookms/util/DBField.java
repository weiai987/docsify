package com.blb.bookms.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 自定义注解，用于标记数据库字段的名称和是否存在
 */
@Target(value = ElementType.FIELD)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface DBField {
    /**
     * 字段名
     * @return
     */
    String fieldName() default "";

    /**
     * 是否存在
     * @return
     */
    boolean exists() default true;
}
