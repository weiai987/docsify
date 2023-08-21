package com.bigdata.nio2;

import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 使用FileChannel读取文件
 * 
 *
 */
public class Demo1 {
	public static void main(String[] args) throws Exception{
		//1创建FileOutputStream
		FileOutputStream fos=new FileOutputStream("d:\\out.txt");
		//2获取通道
		FileChannel outChannel = fos.getChannel();
		//3创建缓冲区
		ByteBuffer buffer=ByteBuffer.allocate(1024);
		//4向缓冲区中放入数据
		buffer.put("hello world".getBytes());
		//5切换为读模式
		buffer.flip();
		//写入
		outChannel.write(buffer);
		//6关闭
		outChannel.close();
		System.out.println("写入完毕");
		
		
	
		
	}
}
