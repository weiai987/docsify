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
		
		//��session��ȡ���û�����
		HttpSession session = request.getSession();
		Object user = session.getAttribute("u");
		//����û�����Ϊ��  
		if(user==null) {
			//���Ե�¼ҳ��  ��ʾ�û���¼
			//��request���з��������Ϣ��ʾ
			request.setAttribute("msg", "�ף����ȵ�¼�ٲ���!!!");
			//ת���� login.jspҳ��
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			return;
		}
		//����service
		BookService  bookService = new BookServiceImpl();
		
		//��ѯ�����鼮
		List<Book> list = bookService.selecAll();
		
		//�����ݷ���request�� 
		request.setAttribute("list", list);
		//ת���� book-list.jspҳ����ʾ
		request.getRequestDispatcher("/book-list.jsp").forward(request, response);
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
