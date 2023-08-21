package com.blb;

import java.io.*;

public class Demo07IO {

    public static void main(String[] args) {
        // 把一个图片的数据读取到程序中，把程序中的数据写到另一个文件（图片）中。 复制
        InputStream input = null ;
        OutputStream output = null ;
        try {
            File f1 = new File("D:\\a\\1.jpg");
            File f2 = new File("D:\\b\\2.jpg");
            // 创建目标文件
            if (!f2.exists()) {
                f2.createNewFile();
            }
            // 把f1读取到程序中
            input = new FileInputStream(f1);
            output = new FileOutputStream(f2);

            byte b[] = new byte[1024];

            int i = 0;
            while ((i = input.read(b)) != -1) {
                output.write(b, 0, i);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                if(input != null ){
                    input.close();
                }

                if(output != null ){
                    output.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
