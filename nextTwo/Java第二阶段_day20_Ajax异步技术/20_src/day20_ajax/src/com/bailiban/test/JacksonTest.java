package com.bailiban.test;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.bailiban.domain.Person;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonTest {

	// Java对象转为JSON字符串
	@Test
	public void test1() throws Exception {
		// 创建Person对象
		Person p = new Person();
		p.setName("如花");
		p.setAge(18);
		p.setSex("女");

		// 创建Jackson的核心对象 ObjectMapper
		ObjectMapper mapper = new ObjectMapper();
		// 转换
		// writeValueAsString(obj):将对象转为json字符串
		String json = mapper.writeValueAsString(p);
		System.out.println(json);// {"name":"如花","age":18,"sex":"女"}
		// writeValue，将数据写到a.txt文件中
		mapper.writeValue(new File("a.txt"), p);
		// writeValue.将数据关联到Writer中
		mapper.writeValue(new FileWriter("b.txt"), p);
	}

	//测试注解
	@Test
	public void test2() throws Exception {
		// 创建Person对象
		Person p = new Person();
		p.setName("如花");
		p.setAge(18);
		p.setSex("女");
		p.setBirthday(new Date());

		// 转换
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(p);

		System.out.println(json);// {"name":"张三","age":23,"gender":"男","birthday":1530958029263}
									// {"name":"如花","age":18,"sex":"女","birthday":"2020-07-12"}
	}

	//测试转换list集合
    @Test
    public void test3() throws Exception {
        //创建Person对象
        Person p1 = new Person();
        p1.setName("如花");
		p1.setAge(18);
		p1.setSex("女");
        p1.setBirthday(new Date());

        Person p2 = new Person();
        p2.setName("小强");
        p2.setAge(18);
        p2.setSex("男");
        p2.setBirthday(new Date());

        Person p3 = new Person();
        p3.setName("旺财");
        p3.setAge(28);
        p3.setSex("男");
        p3.setBirthday(new Date());


        //创建List集合
        List<Person> ps = new ArrayList<Person>();
        ps.add(p1);
        ps.add(p2);
        ps.add(p3);

        //2.转换
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(ps);
        // [{},{},{}]
        //[{"name":"如花","age":18,"sex":"女","birthday":"2020-07-12"},{"name":"小强","age":18,"sex":"男","birthday":"2020-07-12"},{"name":"旺财","age":28,"sex":"男","birthday":"2020-07-12"}]
        System.out.println(json);
    }
   //测试转换map集合
    @Test
    public void test4() throws Exception {
        //1.创建map对象
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("name","张三");
        map.put("age",23);
        map.put("gender","男");


        //2.转换
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(map);
        //{"name":"张三","age":23,"gender":"男"}
        System.out.println(json);//{"gender":"男","name":"张三","age":23}
    }

    //演示 JSON字符串转为Java对象
    @Test
    public void test5() throws Exception {
       //初始化JSON字符串
        String json = "{\"sex\":\"男\",\"name\":\"如花\",\"age\":23}";

        //创建ObjectMapper对象
        ObjectMapper mapper = new ObjectMapper();
        //转换为Java对象 Person对象
        Person person = mapper.readValue(json, Person.class);

        System.out.println(person);
    }

}
