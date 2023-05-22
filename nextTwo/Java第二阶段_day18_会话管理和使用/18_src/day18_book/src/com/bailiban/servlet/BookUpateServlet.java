package com.bailiban.servlet;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import com.bailiban.domain.Book;
import com.bailiban.service.BookService;
import com.bailiban.service.impl.BookServiceImpl;


@WebServlet("/book/update")
public class BookUpateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//����������� 
		request.setCharacterEncoding("utf-8");
		//��ȡ���ύ���в�����map����
		Map<String, String[]> map = request.getParameterMap();
		//����ͼ�����
		Book book  = new Book();
		//��������װ������
		try {
			BeanUtils.populate(book, map);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//����service
		BookService bookService  = new BookServiceImpl();
		//����޸�
		bookService.update(book);
		//��ӳɹ���ת��ͼ���б�ҳ��
		response.sendRedirect(request.getContextPath()+"/book/list");
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
