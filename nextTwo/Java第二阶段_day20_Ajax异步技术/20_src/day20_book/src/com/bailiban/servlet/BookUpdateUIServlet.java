package com.bailiban.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bailiban.domain.Book;
import com.bailiban.service.BookService;
import com.bailiban.service.impl.BookServiceImpl;


@WebServlet("/book/updateUI")
public class BookUpdateUIServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
		//获取书籍id
		int  id  =  Integer.parseInt(request.getParameter("id"));
		//创建service
		BookService  bookService = new BookServiceImpl();
		
		//根据id查询一个书籍
		Book book = bookService.findById(id);
		//将数据放入request域 
		request.setAttribute("book", book);
		//转发到book-update.jsp页面显示
		request.getRequestDispatcher("/book-update.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
