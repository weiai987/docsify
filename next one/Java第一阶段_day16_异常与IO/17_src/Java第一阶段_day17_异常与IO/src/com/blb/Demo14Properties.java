package com.blb;

import java.io.*;
import java.util.Enumeration;
import java.util.Properties;
import java.util.Set;

public class Demo14Properties {

    public static void main(String[] args) throws IOException {
//		创建对应的属性文件
        File  file = new File("d:/blb.properties");

//		建立到文件之间的流
        FileInputStream fis = new FileInputStream(file);
        InputStreamReader read = new InputStreamReader(fis,"utf-8");

//		通过流把配置文件中的数据加载到Properties对象中。
        Properties properties = new Properties();
        properties.load(read);
//      关闭流
        read.close();
        fis.close();

        System.out.println(properties.getProperty("name"));
        System.out.println(properties.getProperty("age"));
        System.out.println(properties.getProperty("sex"));

//		遍历所有内容
        Set<String> keys = properties.stringPropertyNames();
        for (String key:keys) {
            System.out.println( key+ " = "+ properties.getProperty(key));
        }

    }
}
