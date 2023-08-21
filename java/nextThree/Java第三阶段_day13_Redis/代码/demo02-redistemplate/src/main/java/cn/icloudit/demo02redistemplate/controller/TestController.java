package cn.icloudit.demo02redistemplate.controller;

import cn.icloudit.demo02redistemplate.dao.UserDao;
import cn.icloudit.demo02redistemplate.entity.User;
import cn.icloudit.demo02redistemplate.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@RestController
@CrossOrigin
public class TestController {
    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private RedisUtils redisUtils;


    @Autowired
    private UserDao userDao;

    @RequestMapping("/save1")
    public String save1() {
        ValueOperations values = redisTemplate.opsForValue();
        values.set("user", "tom");
        return null;
    }

    @RequestMapping("/save2")
    public String save2(){
        User u = userDao.selectByPrimaryKey(1);

        ValueOperations values = redisTemplate.opsForValue();
        values.set("user1",u);
        return null;
    }

    @RequestMapping("/get1")
    @ResponseBody
    public User get1(){
        ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
        User u = (User)operations.get("user1");
        System.out.println(u);
        return u;
    }

    @RequestMapping("/save3")
    public String save3(){
        redisUtils.set("test","this  is redisutils");
        return null;
    }

    @RequestMapping("/get3")
    public String get3(){
        return (String)redisUtils.get("test");

    }

    @RequestMapping("/del/{key}")
    public void del(@PathVariable("key") String key) {
        redisUtils.remove(key);
    }

    public void saveUsers() {
        //
        List<User> users = userDao.getUsers();
        redisUtils.set("users", users);

    }

    @RequestMapping("/getUsers")
    @ResponseBody
    public List<User> getUsers() {
        //首先判断缓存中是否有需要的数据
        if (redisUtils.get("users") == null) {
            //如果不存在需要的数据，查询出来并放入缓存
            this.saveUsers();
        }
        return (List<User>) redisUtils.get("users");
    }

}
