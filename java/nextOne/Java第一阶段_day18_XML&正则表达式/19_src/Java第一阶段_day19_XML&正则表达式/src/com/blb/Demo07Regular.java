package com.blb;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo07Regular {

    public static void main(String[] args) {
        System.out.println(Pattern.matches("a*b", "aaaaabb"));
		System.out.println(Pattern.matches("[ab]", "ab"));
		System.out.println(Pattern.matches("[a-zA-H]", "Z"));
		System.out.println(Pattern.matches("[^abc]", "d"));
		System.out.println(Pattern.matches("[^abc]", "d"));
		System.out.println(Pattern.matches("[a-k&&c-z]", "z"));
		System.out.println(Pattern.matches("a[a-z]c", "abc"));
		System.out.println(Pattern.matches("\\d", "10"));
		System.out.println(Pattern.matches("\\D", "a"));
		System.out.println(Pattern.matches("\\s", "\t"));
		System.out.println(Pattern.matches("\\S", "a"));
		System.out.println(Pattern.matches("\\w", "a"));//[a-zA-Z_0-9]
		System.out.println(Pattern.matches("\\W", "a"));
		System.out.println(Pattern.matches("^a\\d{4}f$", "a1234f"));
		System.out.println(Pattern.matches("ab?c", "abbc"));
		System.out.println(Pattern.matches("ab*c", "abbbbbbbc"));
		System.out.println(Pattern.matches("a\\d+c", "a12312312312c"));
		System.out.println(Pattern.matches("a\\d{3}c", "a123c"));
		System.out.println(Pattern.matches("a\\d{3,}c", "a12312312312c"));
        System.out.println(Pattern.matches("a\\d{3,5}c", "a123456c"));
    }

}
