package com.bigdata.nio3;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class TcpClient {
	public static void main(String[] args) throws Exception{
		//1创建SocketChannel
		SocketChannel sc=SocketChannel.open(new InetSocketAddress("127.0.0.1", 1234));
		//2创建缓冲区
		String string="你还好吗?";
		ByteBuffer buffer=ByteBuffer.allocate(1024);
		buffer.put(string.getBytes()); 
		buffer.flip();
		//3发送数据
		sc.write(buffer);
		//4关闭
		sc.close();
	}
}
