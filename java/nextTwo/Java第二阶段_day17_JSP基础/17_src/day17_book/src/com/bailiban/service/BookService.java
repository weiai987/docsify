package com.bailiban.service;

import java.util.List;

import com.bailiban.domain.Book;

public interface BookService {
	//查询所有书籍
    List<Book> selecAll();
    //添加图书方法
   void add(Book book);
   //删除图书方法
   void delete(int id);
}
