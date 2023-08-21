package com.bigdata.task;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

public class Client {
    private SocketChannel sc;
    ByteBuffer writeBuffer = ByteBuffer.allocate(1024);
    ByteBuffer readBuffer = ByteBuffer.allocate(1024);

    public static void main(String[] args) {
        new Client();
    }
    public Client() {
        try {
            sc = SocketChannel.open();
            //连接服务端
            sc.connect(new InetSocketAddress(8899));
            //发送消息
            this.write(sc);
            //读取消息
            this.read(sc);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void read(final SocketChannel sc) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        readBuffer.clear();
                        int read = sc.read(readBuffer);
                        readBuffer.flip();
                        System.out.println(new String(readBuffer.array()));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    private void write(final SocketChannel sc) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    Scanner scanner = new Scanner(System.in);
                    String next = scanner.next();
                    writeBuffer.clear();
                    writeBuffer.put(next.getBytes());
                    writeBuffer.flip();
                    try {
                        sc.write(writeBuffer);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
