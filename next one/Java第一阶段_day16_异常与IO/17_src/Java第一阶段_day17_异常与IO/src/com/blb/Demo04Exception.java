package com.blb;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Demo04Exception{

    public static void main(String[] args) throws IOException {
        FileInputStream fs = null ;
        try {
            File file = new File("blb.txt");
            fs = new FileInputStream(file);
            System.exit(1);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
//            无论是否发生了异常都执行关闭打开的文件流
            if(fs!=null){
                fs.close();
            }
        }
    }
}
