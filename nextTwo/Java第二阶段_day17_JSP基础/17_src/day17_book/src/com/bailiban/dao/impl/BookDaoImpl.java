package com.bailiban.dao.impl;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.bailiban.dao.BookDao;
import com.bailiban.domain.Book;
import com.bailiban.utils.JDBCUtils;

public class BookDaoImpl implements BookDao {

    //声明JDBCTemplate对象共用
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
	//查询所有图书
	@Override
	public List<Book> selecAll() {
		
		//查询所有书籍
		List<Book> list = template.query("select * from t_book", new BeanPropertyRowMapper<Book>(Book.class));
		
		return list;
	}
	//添加图书
	@Override
	public void add(Book book) {
		
		//定义添加sql语句
		String sql = "INSERT INTO t_book VALUES (NULL ,?,?,?,?,?)";
		//定义添加参数
		Object[] args = {
				book.getName(),
				book.getPrice(),
				book.getAuthor(),
				book.getImage(),
				book.getPublishDate()
				
		};
		template.update(sql,args );
		
	}
	//删除图书
	@Override
	public void delete(int id) {
		
		//定义sql语句
		String sql = "DELETE From t_book WHERE  id = ? ";
		
		//调用更新方法
		template.update(sql, id);
		
	}
	
	

}
