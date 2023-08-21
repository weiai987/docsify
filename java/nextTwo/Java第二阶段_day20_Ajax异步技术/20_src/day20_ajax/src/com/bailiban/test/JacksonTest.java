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

	// Java����תΪJSON�ַ���
	@Test
	public void test1() throws Exception {
		// ����Person����
		Person p = new Person();
		p.setName("�绨");
		p.setAge(18);
		p.setSex("Ů");

		// ����Jackson�ĺ��Ķ��� ObjectMapper
		ObjectMapper mapper = new ObjectMapper();
		// ת��
		// writeValueAsString(obj):������תΪjson�ַ���
		String json = mapper.writeValueAsString(p);
		System.out.println(json);// {"name":"�绨","age":18,"sex":"Ů"}
		// writeValue��������д��a.txt�ļ���
		mapper.writeValue(new File("a.txt"), p);
		// writeValue.�����ݹ�����Writer��
		mapper.writeValue(new FileWriter("b.txt"), p);
	}

	//����ע��
	@Test
	public void test2() throws Exception {
		// ����Person����
		Person p = new Person();
		p.setName("�绨");
		p.setAge(18);
		p.setSex("Ů");
		p.setBirthday(new Date());

		// ת��
		ObjectMapper mapper = new ObjectMapper();
		String json = mapper.writeValueAsString(p);

		System.out.println(json);// {"name":"����","age":23,"gender":"��","birthday":1530958029263}
									// {"name":"�绨","age":18,"sex":"Ů","birthday":"2020-07-12"}
	}

	//����ת��list����
    @Test
    public void test3() throws Exception {
        //����Person����
        Person p1 = new Person();
        p1.setName("�绨");
		p1.setAge(18);
		p1.setSex("Ů");
        p1.setBirthday(new Date());

        Person p2 = new Person();
        p2.setName("Сǿ");
        p2.setAge(18);
        p2.setSex("��");
        p2.setBirthday(new Date());

        Person p3 = new Person();
        p3.setName("����");
        p3.setAge(28);
        p3.setSex("��");
        p3.setBirthday(new Date());


        //����List����
        List<Person> ps = new ArrayList<Person>();
        ps.add(p1);
        ps.add(p2);
        ps.add(p3);

        //2.ת��
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(ps);
        // [{},{},{}]
        //[{"name":"�绨","age":18,"sex":"Ů","birthday":"2020-07-12"},{"name":"Сǿ","age":18,"sex":"��","birthday":"2020-07-12"},{"name":"����","age":28,"sex":"��","birthday":"2020-07-12"}]
        System.out.println(json);
    }
   //����ת��map����
    @Test
    public void test4() throws Exception {
        //1.����map����
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("name","����");
        map.put("age",23);
        map.put("gender","��");


        //2.ת��
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(map);
        //{"name":"����","age":23,"gender":"��"}
        System.out.println(json);//{"gender":"��","name":"����","age":23}
    }

    //��ʾ JSON�ַ���תΪJava����
    @Test
    public void test5() throws Exception {
       //��ʼ��JSON�ַ���
        String json = "{\"sex\":\"��\",\"name\":\"�绨\",\"age\":23}";

        //����ObjectMapper����
        ObjectMapper mapper = new ObjectMapper();
        //ת��ΪJava���� Person����
        Person person = mapper.readValue(json, Person.class);

        System.out.println(person);
    }

}
