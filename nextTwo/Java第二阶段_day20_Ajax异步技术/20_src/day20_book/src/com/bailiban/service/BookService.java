package com.bailiban.service;

import java.util.List;

import com.bailiban.domain.Book;

public interface BookService {
	// 查询所有书籍
	List<Book> selecAll();

	// 添加图书方法
	void add(Book book);

	// 删除图书方法
	void delete(int id);

	// 根据id查询图书
	Book findById(int id);

	// 修改图书
	void update(Book book);

	// 根据书名查询书籍
	Book findBookByName(String name);
}
