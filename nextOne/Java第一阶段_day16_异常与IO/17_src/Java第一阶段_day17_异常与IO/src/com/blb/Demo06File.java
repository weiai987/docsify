package com.blb;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class Demo06 {

    public static void main(String[] args) throws IOException {
        File file = new File("D:/a.txt");
//      输出个文件是否存在
        System.out.println(file.exists());

        if(!file.exists()){
//            创建这个文件
            file.createNewFile();
        }
//        判断这个文件是否是文件
        System.out.println(file.isFile());
//        判断这个文件是否是目录
        System.out.println(file.isDirectory());
//        输出文件的名字
        System.out.println(file.getName());
//        输出文件的路径
        System.out.println(file.getPath());
//        输出文件的绝对路径
        System.out.println(file.getAbsolutePath());
//         删除此文件
        file.delete();

        File dir = new File("d:/blb");
//        创建这个目录，前提是所有父级目录都存在
        dir.mkdir();
//        创建这个目录，父级目录不存在，则把所有父级目录都创建
        dir.mkdirs();
//        返回dir目录中的所有文件，以String [] 的形式保存
        String[] list = dir.list();
        System.out.println(Arrays.toString(list));

//        返回dir目录中的所有文件，以File [] 的形式保存
        File[] files = dir.listFiles();
        for (File f:files) {
            System.out.println(f.getName());
        }
//        删除此目录，前提是这是一个空目录
        dir.delete();

    }
}
