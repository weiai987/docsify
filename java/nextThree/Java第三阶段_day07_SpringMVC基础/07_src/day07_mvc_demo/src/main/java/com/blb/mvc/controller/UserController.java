package com.blb.mvc.controller;

import com.blb.mvc.entity.UserVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserController {

//    @PostMapping("/login")
//    public void login(String username, String password, HttpSession session){
////        String username = req.getParameter("username");
////        String password = req.getParameter("password");
//        System.out.println("username:"+username);
//        System.out.println("password:"+password);
////        System.out.println(user);
////        if("admin".equals(user.getUsername()) && "123".equals(user.getPassword())){
////            //保存数据
////            //model.addAttribute("user",user);
////            session.setAttribute("user",user);
////            //重定向
////            return "redirect:/pages/index";
////        }
////        model.addAttribute("msg","账号或密码错误");
////        //请求转发
////        return "forward:/pages/login";
//    }

//    @PostMapping("/login")
//    public String login(User user, Model model){
//        if("admin".equals(user.getUsername()) && "123".equals(user.getPassword())){
//            //保存数据
//            model.addAttribute("user",user);
//            //重定向
//            return "redirect:/pages/index";
//        }
//        model.addAttribute("msg","账号或密码错误");
//        //请求转发
//        return "forward:/pages/login";
//    }

    @PostMapping("/login")
    public void login(UserVO userVO, Model model){
        String username = userVO.getUser().get(0);
        String password = userVO.getUser().get(1);
        System.out.println(username+"--"+password);
    }
}
