package com.bigdata.nio4;

import java.net.InetSocketAddress;

import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * 使用Selector实现Tcp服务器端
 */
public class ChatServer {
	public static void main(String[] args) throws Exception {
		// 1创建ServerSocketChannel
		ServerSocketChannel ssc = ServerSocketChannel.open();
		// 2设置为非阻塞式
		ssc.configureBlocking(false);
		// 3绑定地址
		ssc.bind(new InetSocketAddress("127.0.0.1", 9999));
		// 4创建选择器
		Selector selector = Selector.open();
		// 5注册选择器
		ssc.register(selector, SelectionKey.OP_ACCEPT);
		while (selector.select() > 0) {
			Iterator<SelectionKey> it = selector.selectedKeys().iterator();
			while (it.hasNext()) {
				SelectionKey selectionKey = it.next();
				if (selectionKey.isAcceptable()) {//有客户端连接过来了
					SocketChannel socketChannel = ssc.accept();//每个客户端的socketChannel
					//设置为非阻塞式编程
					socketChannel.configureBlocking(false);
					//把客户端socketChannel注册到selctor
					socketChannel.register(selector, selectionKey.OP_READ);
				} else if (selectionKey.isReadable()) {//有数据发送过来了
					// 获取SocketChannel
					SocketChannel channel = (SocketChannel) selectionKey.channel();
					// 创建缓冲区
					ByteBuffer buffer = ByteBuffer.allocate(1024);
					int len = 0;
					while ((len = channel.read(buffer)) > 0) {
						buffer.flip();
						System.out.println(new String(buffer.array(), 0, len));
						buffer.clear();
					}
					if (len == -1) {// 客户端已经退出
						channel.close();
					}
				}
				//删除事件
				it.remove();
			}
		}
	}
}
