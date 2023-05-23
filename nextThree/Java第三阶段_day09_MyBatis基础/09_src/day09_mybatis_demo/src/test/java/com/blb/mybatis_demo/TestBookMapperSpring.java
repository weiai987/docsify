package com.blb.mybatis_demo;

import com.blb.mybatis_demo.dao.BookMapper;
import com.blb.mybatis_demo.entity.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Spring整合单元测试
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-mybatis.xml")
public class TestBookMapperSpring {

    @Autowired
    private BookMapper bookMapper;

    @Test
    public void testInsert(){
        bookMapper.insert(new Book(0,"spring123",99,1,"spring","xx","2000-1-1",0,""));
    }

    @Test
    public void testSelect(){
        bookMapper.findAll().forEach(book -> System.out.println(book));
    }
}
