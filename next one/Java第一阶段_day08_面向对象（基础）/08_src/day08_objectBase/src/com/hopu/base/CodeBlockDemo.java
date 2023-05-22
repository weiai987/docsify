package com.hopu.base;
class CodeBlock {
    //静态代码块：类中方法外，加static修饰，用于给类进行初始化
    static{
        System.out.println("静态代码块");
    }
     
    //构造代码块：类中方法外，用{}括起，每次调用构造方法前执行，用于给对象进行初始化
    {
        System.out.println("构造代码块");
    }
     
    // 构造方法
    public CodeBlock(){
        System.out.println("无参构造");
    }
}
 
public class CodeBlockDemo {
    public static void main(String[] args) {
        {
            System.out.println("局部代码块");
        }
        CodeBlock t2 = new CodeBlock();
        CodeBlock t3 = new CodeBlock();
    }
}