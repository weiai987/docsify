package com.blb.mybatis_demo.dao;


import com.blb.mybatis_demo.entity.Book;

import java.util.List;

/**
 * 书籍表的映射接口
 */
public interface BookMapper {

    void insert(Book book);

    List<Book> findAll();

    Book findById(int id);
}
