package org.hopu.djp.libDemo.utils;

import java.io.PrintStream;

public class TextHelper {
    public static final String infoHead = "爱看>";
    private static final PrintStream out = System.out;

    public static String checkInput(String inputStr, String inputOpt) {
        if(inputStr != null && !"".equals(inputStr)) {
            if(inputStr.length() != 1) {
                out.printf(infoHead + "您的输入不合法，请重新输入。\n");
            } else if(inputStr.indexOf(inputStr) < 0) {
                out.printf(infoHead + "您的输入不合法，请重新输入。\n");
            }
            for(char c : inputOpt.toCharArray()) {
                if(inputStr.charAt(0) == c) {
                    //  输入合法
                    out.printf(infoHead + "您的输入是" + inputStr + "\n");
                    return inputStr;
                }
            }
            //                输入不合法
            out.printf(infoHead + "您的输入非有效选择，请重新输入。\n");
        }
        return null;
    }
}
