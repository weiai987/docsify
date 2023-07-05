package com.bigdata.nio3;

import java.net.InetSocketAddress;

import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * 使用ServerSocketChannel实现服务器端
 * 
 *
 */
public class TcpServer {	
	public static void main(String[] args) throws Exception{
		//1创建ServerSocketChannel
		ServerSocketChannel ssc=ServerSocketChannel.open();
		//2绑定地址
		ssc.bind(new InetSocketAddress(1234));
		//3监听
		System.out.println("服务器已启动");
		SocketChannel sc=ssc.accept();
		//4创建缓冲区
		ByteBuffer buffer=ByteBuffer.allocate(1024); 
		int len=sc.read(buffer);
		buffer.flip(); 
		
		String string=new String(buffer.array(),0, len);
		System.out.println(string);
		//5关闭
		sc.close();
		
	}
}
