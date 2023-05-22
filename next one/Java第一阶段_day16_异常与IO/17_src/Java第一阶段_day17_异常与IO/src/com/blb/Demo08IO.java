package com.blb;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Demo08IO {

    public static void main(String[] args) {
        FileReader fileReader = null;
        try {
//            读取D盘中a.txt文件的内容
            File f = new File("D:\\a.txt");
//            创建对应的输入流
            fileReader = new FileReader(f);
            int c ;
            while((c = fileReader.read())!=-1){
                System.out.println( (char)c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
//                关闭流
                if (fileReader != null) {
                    fileReader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
