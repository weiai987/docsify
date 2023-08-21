package com.bailiban.service.impl;

import java.util.List;

import com.bailiban.dao.BookDao;
import com.bailiban.dao.impl.BookDaoImpl;
import com.bailiban.domain.Book;
import com.bailiban.service.BookService;

public class BookServiceImpl implements BookService {

	// 创建dao
	private BookDao bookDao = new BookDaoImpl();

	// 查询所有数据
	@Override
	public List<Book> selecAll() {
		// TODO Auto-generated method stub
		return bookDao.selecAll();
	}

	// 添加图书
	@Override
	public void add(Book book) {
		bookDao.add(book);
	}

	// 根据id删除图书
	@Override
	public void delete(int id) {
		bookDao.delete(id);
	}

	// 根据id查询一个图书
	@Override
	public Book findById(int id) {
		return bookDao.findById(id);
	}

	// 修改图书
	@Override
	public void update(Book book) {
		bookDao.update(book);
	}

	// 根据书名查询书籍
	@Override
	public Book findBookByName(String name) {
		
		return bookDao.findBookByName(name);

	}

}
