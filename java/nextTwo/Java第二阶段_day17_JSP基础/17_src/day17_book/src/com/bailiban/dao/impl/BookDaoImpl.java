package com.bailiban.dao.impl;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.bailiban.dao.BookDao;
import com.bailiban.domain.Book;
import com.bailiban.utils.JDBCUtils;

public class BookDaoImpl implements BookDao {

    //����JDBCTemplate������
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
	//��ѯ����ͼ��
	@Override
	public List<Book> selecAll() {
		
		//��ѯ�����鼮
		List<Book> list = template.query("select * from t_book", new BeanPropertyRowMapper<Book>(Book.class));
		
		return list;
	}
	//���ͼ��
	@Override
	public void add(Book book) {
		
		//�������sql���
		String sql = "INSERT INTO t_book VALUES (NULL ,?,?,?,?,?)";
		//������Ӳ���
		Object[] args = {
				book.getName(),
				book.getPrice(),
				book.getAuthor(),
				book.getImage(),
				book.getPublishDate()
				
		};
		template.update(sql,args );
		
	}
	//ɾ��ͼ��
	@Override
	public void delete(int id) {
		
		//����sql���
		String sql = "DELETE From t_book WHERE  id = ? ";
		
		//���ø��·���
		template.update(sql, id);
		
	}
	
	

}
