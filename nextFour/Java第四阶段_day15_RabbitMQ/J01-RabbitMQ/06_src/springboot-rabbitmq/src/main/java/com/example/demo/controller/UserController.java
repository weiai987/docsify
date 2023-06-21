package com.example.demo.controller;

import com.example.demo.pojo.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.HashMap;
import java.util.Map;

/**
 * 用户
 * @author :master
 * @date :20200609
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    public Map<String, Object> findUserById(String userId) {
        User user = userService.findUserById(userId);
        Map<String, Object> map = new HashMap<>(16);
        if (!StringUtils.isEmpty(user)) {
            map.put("user", user);
            map.put("code", "0000");
            map.put("msg", "成功");
        }
        map.put("user", null);
        map.put("code", "-1");
        map.put("msg", "失败");

        return map;
    }


}
