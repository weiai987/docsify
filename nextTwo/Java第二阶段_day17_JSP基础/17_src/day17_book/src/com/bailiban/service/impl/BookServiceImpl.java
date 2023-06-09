package com.bailiban.service.impl;

import java.util.List;

import com.bailiban.dao.BookDao;
import com.bailiban.dao.impl.BookDaoImpl;
import com.bailiban.domain.Book;
import com.bailiban.service.BookService;

public class BookServiceImpl implements BookService {
	
	//创建dao
	private BookDao  bookDao = new BookDaoImpl();

	//查询所有数据
	@Override
	public List<Book> selecAll() {
		// TODO Auto-generated method stub
		return bookDao.selecAll();
	}

	//添加图书
	@Override
	public void add(Book book) {
		
		bookDao.add(book);
	}

	//根据id删除图书
	@Override
	public void delete(int id) {
		
		bookDao.delete(id);
	}

}
