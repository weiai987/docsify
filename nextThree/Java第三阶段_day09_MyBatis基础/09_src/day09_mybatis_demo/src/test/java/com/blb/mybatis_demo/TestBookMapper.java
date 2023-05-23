package com.blb.mybatis_demo;

import com.blb.mybatis_demo.dao.BookMapper;
import com.blb.mybatis_demo.entity.Book;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

public class TestBookMapper {

    @Test
    public void testInsert(){
        //创建SQLSessionFactoryBuilder对象，用于创建SQLSessionFactory
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        //创建SqlSessionFactory
        try {
            SqlSessionFactory factory = builder.build(Resources.getResourceAsStream("mybatis-config.xml"));
            //SqlSessionFactory用于创建SqlSession会话
            try(SqlSession session = factory.openSession()){
                //通过session获得Mapper对象
                BookMapper mapper = session.getMapper(BookMapper.class);
                //执行操作
                mapper.insert(new Book(0L,"test-11",88,1,"xx","xx","2011-1-1",0,"xx.jpg"));
                //提交修改
                session.commit();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSelectAll(){
        //创建SQLSessionFactoryBuilder对象，用于创建SQLSessionFactory
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        //创建SqlSessionFactory
        try {
            SqlSessionFactory factory = builder.build(Resources.getResourceAsStream("mybatis-config.xml"));
            //SqlSessionFactory用于创建SqlSession会话
            try(SqlSession session = factory.openSession()){
                //通过session获得Mapper对象
                BookMapper mapper = session.getMapper(BookMapper.class);
                //执行操作
                List<Book> books = mapper.findAll();
                books.forEach(book -> System.out.println(book));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCacheLevel1() throws IOException {
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(
                Resources.getResourceAsStream("mybatis-config.xml"));
        SqlSession sqlSession = factory.openSession();
        BookMapper mapper = sqlSession.getMapper(BookMapper.class);
        Book book = mapper.findById(6);
        sqlSession.close();
        SqlSession sqlSession2 = factory.openSession();
        mapper = sqlSession2.getMapper(BookMapper.class);
        Book book1 = mapper.findById(6);
        Book book3 = mapper.findById(6);
        System.out.println(book);
        System.out.println(book1);
        System.out.println(book3);
    }
}
