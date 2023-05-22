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
    
		//��ȡ�鼮id
		int  id  =  Integer.parseInt(request.getParameter("id"));
		//����service
		BookService  bookService = new BookServiceImpl();
		
		//����id��ѯһ���鼮
		Book book = bookService.findById(id);
		//�����ݷ���request�� 
		request.setAttribute("book", book);
		//ת����book-update.jspҳ����ʾ
		request.getRequestDispatcher("/book-update.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
