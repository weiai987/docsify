package com.demo;

import com.demo.util.RedisUtils;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class Springboot02MybatisApplicationTests {

    @Autowired
    private RedisUtils redisUtils;



    @Test
    public void setRedisData() {
        redisUtils.set("flag","demo");
        System.out.println("success");
    }

    @Test
    public void getRedisData() {
        String flag = redisUtils.get("flag").toString();
        System.out.println(flag);
    }

}
