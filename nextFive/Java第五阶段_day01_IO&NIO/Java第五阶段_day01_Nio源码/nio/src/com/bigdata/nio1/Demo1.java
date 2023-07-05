package com.bigdata.nio1;

import java.nio.ByteBuffer;

/**
 * 使用NIO的Buffer操作数据
 * 
 *  // Invariants: mark <= position <= limit <= capacity
    private int mark = -1;
    private int position = 0;  //表示当前的位置
    private int limit;  //表示读取限制的位置
    private int capacity; //表示缓冲区的容量
 *
 */
public class Demo1 {
	public static void main(String[] args) {
		//1创建缓冲区
		ByteBuffer buffer=ByteBuffer.allocate(1024);
		//2向缓冲区中添加内容
		buffer.put("helloworld".getBytes());
		//3切换为读模式
		buffer.flip();

		//4获取多个字节
		byte[] data=new byte[buffer.limit()]; 
		buffer.get(data);
		System.out.println(new String(data));
		//5清空缓冲区
		buffer.clear();
	}
}
