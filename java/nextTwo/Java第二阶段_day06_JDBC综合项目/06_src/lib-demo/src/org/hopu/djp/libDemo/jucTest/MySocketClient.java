package org.hopu.djp.libDemo.jucTest;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class MySocketClient {
    private static final String serverIp = "192.168.43.32";
    private static final int port = 54321;

    public void startClient(int x) throws IOException {
        System.out.println("开始第" + x + "个连接会话");
        Socket sc = new Socket(serverIp, port);
        System.out.println("client started.");
        DataOutputStream os = null;
        DataInputStream is = null;
//        Scanner scanner = new Scanner(System.in);
        while(true) {
            os = new DataOutputStream(sc.getOutputStream());
            is = new DataInputStream(sc.getInputStream());
//            String msgOut = scanner.nextLine();
            String msgOut = "client-" + x;
            os.writeUTF(msgOut);
            System.out.println("client>" + msgOut);
            String msgIn = is.readUTF();
            System.out.println("server>" + msgIn);
            if("exit".equals(msgOut)) {
                sc.close();
                System.out.println("client close");
                break;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        MySocketClient msc = new MySocketClient();
        int x = 0;
        for(; x<50; x++) {
            msc.startClient(x);
        }
    }
}
