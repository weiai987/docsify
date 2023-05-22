package org.hopu.djp.libDemo.dao;

import org.hopu.djp.libDemo.entity.Book;
import org.hopu.djp.libDemo.entity.User;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

public interface IBookDao {
//    新增图书
    int addOne(Book book, int oprId);
//    查看所有图书
    List<Book> findAll();
//    查看指定图书
    Book findById(int bookId);
    List<Book> findList(Book book);
//    修改指定图书
    int editOne(Book book, int oprId);
//    删除指定用户
    int delOneById(int bookId, int oprId);
//    禁用/启用指定图书
    int enableById(int bookId, Boolean b, int oprId);
//    从结果集转换成实体类
    Book toBook(ResultSet rs);
}
