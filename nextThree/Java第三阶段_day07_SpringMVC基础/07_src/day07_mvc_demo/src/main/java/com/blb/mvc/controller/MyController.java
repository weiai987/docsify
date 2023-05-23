package com.blb.mvc.controller;

import com.blb.mvc.entity.Student;
import com.blb.mvc.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * 自定义控制器
 */
@Controller
public class MyController {

    //配置请求的URL路径 http://localhost:8080/index
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String toIndex() {
        //视图解析器 ： index --> /WEB-INF/page/index.jsp
        return "index";
    }

    @GetMapping("/login")
    public String toLogin() {
        return "login";
    }

    @RequestMapping("/pages/{page}")
    public String toPage(@PathVariable("page") String page) {
        System.out.println("跳转页面：" + page);
        return page;
    }

    @ResponseBody
    @RequestMapping("/ajax")
    public List<User> ajaxTest(@RequestBody User user) {
        System.out.println("收到了JSON对象："+user);
        //返回JSON集合给ajax
        List<User> users = Arrays.asList(new User("user-1","123"),
                new User("user-2","123"),
                new User("user-3","123"));
        return users;
    }

    @PostMapping("/saveStudent")
    public void saveStudent(Student student){
        System.out.println(student.getId());
        System.out.println(student.getName());
        System.out.println(student.getAge());
        System.out.println(student.getSubject());
    }
}
