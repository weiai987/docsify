package com.bigdata.nio4;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

/**
 * 聊天客户端代码
 * 
 */
public class ChatClient {
	public static void main(String[] args) throws Exception {

		// 1创建SocketChannel
		SocketChannel sc = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9999));
		// 2设置为非阻塞式
		sc.configureBlocking(false);
		// 3创建缓冲区
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		Scanner input = new Scanner(System.in);
		while (input.hasNext()) {
			String s = input.nextLine();
			buffer.put(s.getBytes());
			buffer.flip();
			sc.write(buffer);
			buffer.clear();
			if (s.equals("886")) {
				break;
			}
		}
		// 4关闭
		sc.close();
	}
}