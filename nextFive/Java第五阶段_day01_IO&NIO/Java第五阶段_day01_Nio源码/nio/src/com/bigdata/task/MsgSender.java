package com.bigdata.task;

import java.util.Scanner;

public class MsgSender implements Runnable{
    private Msg msg;

    public MsgSender(Msg msg) {
        this.msg = msg;
    }

    public void run() {
        while (true) {
            System.out.println("input:\n");
            Scanner scanner = new Scanner(System.in);
            this.msg.setContent(scanner.next());
            this.msg.setFlag(true);
        }
    }
}
