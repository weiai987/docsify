package com.blb.bookms;

import com.blb.bookms.dao.IBookDAO;
import com.blb.bookms.dao.IBookTypeDAO;
import com.blb.bookms.dao.IUserDAO;
import com.blb.bookms.entity.Book;
import com.blb.bookms.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = "classpath:spring.xml")
public class BookDAOTest {

    @Autowired
    private IBookDAO bookDAO;

    @Autowired
    private IBookTypeDAO bookTypeDAO;

    @Autowired
    private IUserDAO userDAO;

//    @Test
    public void testBookDAO(){
//        Book book = bookDAO.selectBookById(1);
//        System.out.println(book);
//        int count = bookDAO.selectCount();
//        System.out.println(count);
//        int count = bookDAO.selectCountType(1);
//        System.out.println(count);
//        Book book = bookDAO.selectBookById(1);
//        book.setBookName("新书123");
//        bookDAO.updateBook(book);
//        book = bookDAO.selectBookById(1);
//        System.out.println(book);
//          bookDAO.saveBook(new Book(0,"新书999",99,1,"abc","ccc","1999-1-1",0,"xx"));
//        bookTypeDAO.selectAllBookType().forEach(type -> System.out.println(type));

//        User login = userDAO.login("test-1", "123");
//        System.out.println(login);
        List<Book> books = bookDAO.selectBooksLimit(0, 10);
        books.forEach(type -> System.out.println(type));
    }

//    @Test
    public void testBookSelect(){
//        Book book = new Book();
////        book.setBookName("书籍88");
//        book.setAuthor("xx");
////        book.setPrice(88);
//        List<Book> books = bookDAO.selectBooksByBook(book);
//        System.out.println(books);
//        List<Book> books = bookDAO.selectBooksByTypeId(1);
//        System.out.println(books);
        Book book = bookDAO.selectBookById(1);
        System.out.println(book.getBookName());
        System.out.println(book.getBookType().getType());
    }

//    @Test
    public void testBookUpdate(){
        Book book = new Book();
        book.setId(6);
        book.setBookName("Python入门到放弃");
        bookDAO.updateBook(book);
        Book book1 = bookDAO.selectBookById(6);
        System.out.println(book1);
    }

//    @Test
    public void testBookNamesList(){
        List<String> names = Arrays.asList("书籍1","书籍11","书籍15");
        List<Book> books = bookDAO.selectBooksByBookNameList(names);
        books.forEach(book -> System.out.println(book));
    }

}
