package com.blb;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Demo11IO {

    public static void main(String[] args) throws IOException {
        File f = new File("D:\\blb.txt");
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        fileWriter = new FileWriter(f,true);// 第2个参数表示是追加还是覆盖
        bufferedWriter = new BufferedWriter(fileWriter);

        bufferedWriter.newLine();
        bufferedWriter.write("床前明月光");
        bufferedWriter.newLine();
        bufferedWriter.write("疑是地上霜");
        bufferedWriter.newLine();
        bufferedWriter.write("举头望明月");
        bufferedWriter.newLine();
        bufferedWriter.write("低头思故乡");

        bufferedWriter.flush();

        bufferedWriter.close();
        fileWriter.close();
    }
}
