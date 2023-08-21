package com.bailiban.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bailiban.domain.Book;
import com.bailiban.service.BookService;
import com.bailiban.service.impl.BookServiceImpl;

/**
 * Servlet implementation class BookListServlet
 */
@WebServlet("/book/list")
public class BookListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//从session中取出用户对象
		HttpSession session = request.getSession();
		Object user = session.getAttribute("u");
		//如果用户对象为空  
		if(user==null) {
			//回显登录页面  提示用户登录
			//向request域中放入错误信息提示
			request.setAttribute("msg", "亲！请先登录再操作!!!");
			//转发到 login.jsp页面
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}
		//创建service
		BookService  bookService = new BookServiceImpl();
		
		//查询所有书籍
		List<Book> list = bookService.selecAll();
		
		//将数据放入request域 
		request.setAttribute("list", list);
		//转发到 book-list.jsp页面显示
		request.getRequestDispatcher("/book-list.jsp").forward(request, response);
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
