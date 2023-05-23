package com.blb.bookms.controller;

import com.blb.bookms.entity.User;
import com.blb.bookms.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping("/login")
    public String login(String username, String password, Model model, HttpSession session){
        User user = userService.login(username, password);
        if(user == null){
            model.addAttribute("msg","账号或密码错误");
            return "forward:/pages/login";
        }else{
            //登录成功在session中保存用户
            session.setAttribute("user",user);
            return "redirect:/pages/index";
        }
    }
}
