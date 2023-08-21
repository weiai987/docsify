package cn.icloudit;

import org.junit.Test;
import redis.clients.jedis.Jedis;

public class TestJedis {

    @Test
    public void demo01(){
        Jedis jedis = new Jedis("127.0.0.1",6379);
        jedis.connect();;

        jedis.setnx("name","tom");
        jedis.set("gender","boy");
        jedis.setex("age",10, "18");
        System.out.println(jedis.get("gender"));
        jedis.close();
    }
}
