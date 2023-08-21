package com.bailiban.service.impl;

import java.util.List;

import com.bailiban.dao.BookDao;
import com.bailiban.dao.impl.BookDaoImpl;
import com.bailiban.domain.Book;
import com.bailiban.service.BookService;

public class BookServiceImpl implements BookService {

	// ����dao
	private BookDao bookDao = new BookDaoImpl();

	// ��ѯ��������
	@Override
	public List<Book> selecAll() {
		// TODO Auto-generated method stub
		return bookDao.selecAll();
	}

	// ���ͼ��
	@Override
	public void add(Book book) {
		bookDao.add(book);
	}

	// ����idɾ��ͼ��
	@Override
	public void delete(int id) {
		bookDao.delete(id);
	}

	// ����id��ѯһ��ͼ��
	@Override
	public Book findById(int id) {
		return bookDao.findById(id);
	}

	// �޸�ͼ��
	@Override
	public void update(Book book) {
		bookDao.update(book);
	}

	// ����������ѯ�鼮
	@Override
	public Book findBookByName(String name) {
		
		return bookDao.findBookByName(name);

	}

}
