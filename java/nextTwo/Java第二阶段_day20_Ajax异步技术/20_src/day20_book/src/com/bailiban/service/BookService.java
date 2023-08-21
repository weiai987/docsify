package com.bailiban.service;

import java.util.List;

import com.bailiban.domain.Book;

public interface BookService {
	// ��ѯ�����鼮
	List<Book> selecAll();

	// ���ͼ�鷽��
	void add(Book book);

	// ɾ��ͼ�鷽��
	void delete(int id);

	// ����id��ѯͼ��
	Book findById(int id);

	// �޸�ͼ��
	void update(Book book);

	// ����������ѯ�鼮
	Book findBookByName(String name);
}
