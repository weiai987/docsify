package com.blb;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Demo09IO {

    public static void main(String[] args) {
        File f = new File("D:\\blb.txt");
        FileWriter fileWriter = null;
        try {
//          创建文件输出流
            fileWriter = new FileWriter(f,true);// 第2个参数表示是追加还是覆盖
            fileWriter.write("昨夜雨疏风骤，浓睡不消残酒。试问卷帘人，却道海棠依旧。知否，知否？应是绿肥红瘦。");

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(fileWriter!=null){
                    fileWriter.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
