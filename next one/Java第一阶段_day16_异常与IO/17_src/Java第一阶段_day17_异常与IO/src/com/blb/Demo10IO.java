package com.blb;

import java.io.*;

public class Demo10IO {

    public static void main(String[] args) throws IOException {
        FileReader fileReader = null;
        BufferedReader bufferdReader = null;
        bufferdReader = new BufferedReader(fileReader);
//      读取D盘中a.txt文件的内容
        File f = new File("D:\\blb.txt");
//      创建对应的输入流
        fileReader = new FileReader(f);
        String s = null;

        while((s = bufferdReader.readLine())!=null){
            System.out.println(s);
        }
//      关闭流
        bufferdReader.close();
        fileReader.close();

    }
}
