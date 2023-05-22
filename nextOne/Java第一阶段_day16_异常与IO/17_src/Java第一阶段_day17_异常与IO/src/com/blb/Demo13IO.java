package com.blb;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Properties;

public class Demo13IO {

    public static void main(String[] args) throws IOException {
//		创建对应的属性文件
        File  file = new File("d:/blb.properties");
        if(!file.exists()){
            file.createNewFile();
        }
//      创建Properties对象，存储数据
        Properties p = new Properties();
        p.setProperty("name", "张三");
        p.setProperty("age", "22");
        p.setProperty("sex", "男");

//        通过OutputStreamWriter包装一层流，可以处理乱码问题
        FileOutputStream fos = new FileOutputStream(file);
        OutputStreamWriter osw = new OutputStreamWriter(fos,"utf-8");

//      将Properties中的数据直接通过流写出去
        p.store(osw,"");
//      关闭流
        osw.close();
        fos.close();
    }
}
