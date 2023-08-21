package com.spring.security.test;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @Author:
 * @Description:
 * @Date Create in
 */
public class Test {
    public static void main(String[] args) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        System.out.println(passwordEncoder.encode("123456"));
    }
}
