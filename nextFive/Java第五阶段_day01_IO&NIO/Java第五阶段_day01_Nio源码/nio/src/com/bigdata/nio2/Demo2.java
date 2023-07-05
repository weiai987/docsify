package com.bigdata.nio2;

import java.io.FileInputStream;

import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;


/**
 * 使用FileChannel写入文件 
 *
 */
public class Demo2 {
	public static void main(String[] args) throws Exception {
		// 1创建FileInputStream
		FileInputStream fis = new FileInputStream("d:\\out.txt");
		// 2创建通道
		FileChannel inChannel = fis.getChannel();
		// 3创建缓冲区
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		int len = inChannel.read(buffer);
		// 4处理数据
		buffer.flip();
		String data = new String(buffer.array(), 0, len);
		System.out.println(data);

		// 5关闭
		fis.close();

	}
}