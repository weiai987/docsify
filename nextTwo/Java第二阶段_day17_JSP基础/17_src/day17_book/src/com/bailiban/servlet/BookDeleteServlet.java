package com.bailiban.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bailiban.service.BookService;
import com.bailiban.service.impl.BookServiceImpl;


@WebServlet("/book/delete")
public class BookDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 接收数据
		String str_id = request.getParameter("id");
		// 将id转换为int
		int id = Integer.parseInt(str_id);
		// 创建service
		BookService bookService = new BookServiceImpl();
		//调用删除方法
		bookService.delete(id);
		//删除成功跳转到列表页面
		response.sendRedirect(request.getContextPath()+"/book/list");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
