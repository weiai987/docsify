package com.blb.bookms;

import com.blb.bookms.dao.IBookTypeDAO;
import com.blb.bookms.entity.BookType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = "classpath:spring-mybatis.xml")
public class BookTypeDAOTest {

    @Autowired
    private IBookTypeDAO bookTypeDAO;

//    @Test
    public void testBookTypeSelect(){
        BookType bookTypes = bookTypeDAO.selectBookTypeById(1);
        System.out.println(bookTypes.getType());
        System.out.println(bookTypes.getBooks());
    }
}
