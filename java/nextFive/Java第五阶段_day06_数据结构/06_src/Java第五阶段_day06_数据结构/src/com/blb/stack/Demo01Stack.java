package com.blb.stack;

import java.util.Stack;

public class Demo01Stack {

    public static void main(String[] args) {
//      创建栈结构
        Stack<String> stack=new Stack<String>();
//      检测栈中是否是空
        System.out.println(stack.empty());

//      压栈
        stack.push("刘备");
        stack.push("关羽");
        stack.push("张飞");
        stack.push("赵云");
        stack.push("黄忠");

//      出栈，将栈顶元素弹出
        stack.pop();

//      查看栈顶元素
        System.out.println(stack.peek());
    }
}
