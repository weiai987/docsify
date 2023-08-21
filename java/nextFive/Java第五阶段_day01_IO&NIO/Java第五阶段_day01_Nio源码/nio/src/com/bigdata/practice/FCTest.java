package com.bigdata.practice;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
public class FCTest {

    public void fileChannelCopy(File src, File dst) throws IOException {
        FileChannel inChannel =new FileInputStream(src).getChannel();
        FileChannel outChannel=new FileOutputStream(dst).getChannel();
        inChannel.transferTo(0, inChannel.size(), outChannel);
        inChannel.close();
        outChannel.close();
    }

    public void fileCopyNIO(String source, String target) throws IOException {
        // 获取源文件和目标文件的输入输出流
        FileInputStream fin = new FileInputStream(source);
        FileOutputStream fout = new FileOutputStream(target);
        // 获取输入输出通道
        FileChannel fcin = fin.getChannel();
        FileChannel fcout = fout.getChannel();
        // 创建缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        while (fcin.read(buffer)!=-1){// 从输入通道中将数据读到缓冲区,read方法返回读取的字节数，可能为零，如果该通道已到达流的末尾，则返回-1
            // flip方法让缓冲区可以将新读入的数据写入另一个通道
            buffer.flip();
            // 从输出通道中将数据写入缓冲区
            fcout.write(buffer);
            // clear方法重设缓冲区，使它可以接受读入的数据
            buffer.clear();
        }
    }
    public static void main(String[] args) throws IOException {
//        File f1 = new File("D:\\idea\\jiaoyan\\mysocket02\\src\\b.txt");
//        File f2 = new File("D:\\idea\\jiaoyan\\mysocket02\\src\\c.txt");
        FCTest fcTest = new FCTest();
//        fcTest.fileChannelCopy(f1,f2);
        fcTest.fileCopyNIO("D:\\idea\\jiaoyan\\mysocket02\\src\\b.txt","D:\\idea\\jiaoyan\\mysocket02\\src\\d.txt");
    }

}
