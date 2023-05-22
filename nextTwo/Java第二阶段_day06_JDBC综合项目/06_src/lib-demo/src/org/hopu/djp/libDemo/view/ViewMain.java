package org.hopu.djp.libDemo.view;

import org.hopu.djp.libDemo.entity.User;
import org.hopu.djp.libDemo.utils.TextHelper;

import java.io.PrintStream;
import java.util.Scanner;

/**
 * 主命令窗口
 */
public class ViewMain extends ViewParent{
    private static User loginUser = null;


//    打印欢迎界面
    public void showHello() {
        StringBuffer str = new StringBuffer();
        str.append("∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷\n");
        str.append("∷∷∷∷∷∷∷∷       　　　　　　　　欢迎使用　　　　　　　　         ∷∷∷∷∷∷∷∷\n");
        str.append("∷∷∷∷∷∷∷∷       　　　　　　爱看图书借阅系统　            　　　∷∷∷∷∷∷∷∷\n");
        str.append("∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷∷");
        out.println(str.toString());
    }

    public void showState() {
//      显示当前用户状态
        StringBuffer str = new StringBuffer();
        if(loginUser == null) {
            str.append("\n" + TextHelper.infoHead + "当前状态：未登录  \n");
            out.printf(str.toString());
        } else {
            str.append("\n" + TextHelper.infoHead + "登录用户：" + loginUser.getUserRealname());
            str.append("    用户类型：" + loginUser.getUserType() + "\n");
            out.printf(str.toString());
        }
    }

    public String showNoLogin() {
//      显示未登录状态下可选菜单
        StringBuffer str = new StringBuffer();
        str.append(TextHelper.infoHead + "可以选择输入：\n");
        str.append(TextHelper.infoHead + "1、注册用户    2、显示当前可借阅图书信息    3、用户登录    0、退出\n");
        str.append(TextHelper.infoHead);
        out.printf(str.toString());
        return "1230";
    }

    public String showLogin() {
//      显示登录状态下可选菜单
        StringBuffer str = new StringBuffer();
//        判断一下登录用户是否时管理员
        if("管理员".equals(loginUser.getUserType())) {
//            如果是管理员
            str.append(TextHelper.infoHead + "可以选择输入：\n");
            str.append(TextHelper.infoHead + "1、维护      4书籍库存       2、查看待处理接还书流程        0、退出\n");
            str.append(TextHelper.infoHead);
            out.printf(str.toString());
            return "120";
        } else {
//            如果是普通用户
            str.append(TextHelper.infoHead + "可以选择输入：\n");
            str.append(TextHelper.infoHead + "1、显示当前可借阅图书信息     2、显示已借阅图书信息      0、退出\n");
            str.append(TextHelper.infoHead);
            out.printf(str.toString());
            return "120";
        }
    }

    public String getUserInput(String inputOpt) {
        String s = scan.nextLine();
        return TextHelper.checkInput(s, inputOpt);
    }




    public void mainWin() {
//     展现欢迎界面
        showHello();
        while(true) {
            //显示登录状态
            showState();
            //检查登录状态，判断下一步显示菜单
            if(loginUser == null) {
                //显示未登录菜单
                String userInput = getUserInput(showNoLogin());
                switch (userInput) {
                    case "1" :
//                        开始用户注册
                        ViewUser.RegUser();
                        break;
                    case "2" :
//                        显示图书数据
                        ViewBook.viewBookList();
                        break;
                    case "3" :
                        loginUser = ViewUser.userLogin();
                        break;
                    case "0" :
                        out.printf("退出爱看图书借阅系统。");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("default");
                }
            } else {
                //显示已登录菜单
                String userInput = getUserInput(showLogin());
                switch (userInput) {
                    case "1" :
//                        开始显示图书数据
                        ViewBook.viewBookList();
//                        显示下级操作，借阅图书
                        break;
                    case "2" :
//                        显示借阅数据
//                        显示下级操作，归还图书
//                        ViewBook.viewBookList();
                        break;
                    case "0" :
                        out.printf("退出爱看图书借阅系统。");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("default");
                }
            }
        }
    }
}
