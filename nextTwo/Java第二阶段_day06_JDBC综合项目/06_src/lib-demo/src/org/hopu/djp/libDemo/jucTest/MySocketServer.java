package org.hopu.djp.libDemo.jucTest;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class MySocketServer {
    private static final int PORT = 54321;

    public void startServer() throws IOException {
        ServerSocket sc = new ServerSocket(PORT);
        DataInputStream is = null;
        DataOutputStream os = null;

        try {
            while(true) {
                Socket client = sc.accept();
                InetAddress inetAddress = client.getInetAddress();
                System.out.println("客户端{"+inetAddress.getHostAddress()+"}开始连接");
                is = new DataInputStream(client.getInputStream());
                os = new DataOutputStream(client.getOutputStream());

                String str = is.readUTF();
                System.out.println("client>" + str);
                System.out.println("server>" + str.toUpperCase());
                os.writeUTF(str.toUpperCase());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        MySocketServer mss = new MySocketServer();
        mss.startServer();
    }
}
