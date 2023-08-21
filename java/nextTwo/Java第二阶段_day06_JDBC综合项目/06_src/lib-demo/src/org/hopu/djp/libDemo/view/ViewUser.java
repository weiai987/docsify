package org.hopu.djp.libDemo.view;

import org.hopu.djp.libDemo.entity.User;
import org.hopu.djp.libDemo.service.IUsreService;
import org.hopu.djp.libDemo.service.impl.UserServiceImpl;
import org.hopu.djp.libDemo.utils.TextHelper;

import java.io.PrintStream;
import java.util.Scanner;

public class ViewUser extends ViewParent {
    private static final IUsreService userService = new UserServiceImpl();

    public static void RegUser() {
        User regUser = new User();
//       收集用户信息并注册
        while(true) {
            out.printf(TextHelper.infoHead + "请输入用户登录名称，至少4位字符长：");
            String loginName = scan.nextLine();
            if(loginName != null && !"".equals(loginName) && loginName.length() >= 4) {
                regUser.setUserName(loginName);
                break;
            }
            out.printf(TextHelper.infoHead + "输入不合法，请重新输入。\n");
        }
        while(true) {
            out.printf(TextHelper.infoHead + "请输入用户真实名称，至少2位字符长：");
            String realName = scan.nextLine();
            if(realName != null && !"".equals(realName) && realName.length() >= 2) {
                regUser.setUserRealname(realName);
                break;
            }
            out.printf(TextHelper.infoHead + "输入不合法，请重新输入。\n");
        }
        while(true) {
            out.printf(TextHelper.infoHead + "请输入用户登录密码，至少6位字符长：");
            String pwd = scan.nextLine();
            if(pwd != null && !"".equals(pwd) && pwd.length() >= 4) {
                regUser.setUserPassword(pwd);
                break;
            }
            out.printf(TextHelper.infoHead + "输入不合法，请重新输入。\n");
        }
        int result = userService.addUser(regUser, 0);
        if(result == 1) {
            out.printf(TextHelper.infoHead + "用户注册成功。\n");
        } else {
            out.printf(TextHelper.infoHead + "用户注册失败。\n");
        }
    }

    public static User userLogin() {
        User regUser = new User();
//       收集用户信息并注册
        while(true) {
            out.printf(TextHelper.infoHead + "请输入用户登录名称，至少4位字符长：");
            String loginName = scan.nextLine();
            if(loginName != null && !"".equals(loginName) && loginName.length() >= 4) {
                regUser.setUserName(loginName);
                break;
            }
            out.printf(TextHelper.infoHead + "输入不合法，请重新输入。\n");
        }
        while(true) {
            out.printf(TextHelper.infoHead + "请输入用户登录密码，至少6位字符长：");
            String pwd = scan.nextLine();
            if(pwd != null && !"".equals(pwd) && pwd.length() >= 4) {
                regUser.setUserPassword(pwd);
                break;
            }
            out.printf(TextHelper.infoHead + "输入不合法，请重新输入。\n");
        }
        regUser = userService.loginUser(regUser);
        if(regUser != null) {
            out.printf(TextHelper.infoHead + "用户登录成功。\n");
            return regUser;
        } else {
            out.printf(TextHelper.infoHead + "用户登录失败。\n");
            return null;
        }
    }
}
