package org.hopu.djp.libDemo.jucTest;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.Scanner;

public class TextHelper {
    private static final int rowLimit = 4;
    private static final int colLimit = 60;

    public void readTest(String filePath) throws Exception {
        Scanner sc = new Scanner(System.in);
        File f = new File(filePath);
        if(f.exists()) {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            int rowNum = 0;

            System.out.println("Start read " + filePath);
            while(true) {
                String s = sc.nextLine();
                if(s == null) {
                    System.out.println("input is null");
                } else if("".equals(s.trim())){
                    for(int i=0; i<rowLimit; i++) {
                        String x = br.readLine();
                        while(x.length() > colLimit) {
                            String xx = x.substring(0, colLimit);
                            x = x.substring(colLimit);
                            System.out.println(xx);
                        }
                        System.out.println(x);
                        rowNum += 1;
                    }
                } else {
//                    跳过n行
                    int n = Integer.valueOf(s);
                    for(int i=0; i<n; i++) {
                        br.readLine();
                    }
                }
            }
        } else {
            System.out.println("file is not exists.");
        }
    }

    private String changeEncode(String src, String from, String to) throws Exception {
        String result = null;
        result = new String(src.getBytes(from), to);
        return result;
    }

    public static void main(String[] args) throws Exception {
        String s = "H:\\GMS\\books\\fff\\聊天修真群.txt";
        TextHelper t = new TextHelper();
        t.readTest(s);
    }
}
