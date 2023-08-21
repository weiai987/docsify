package com.bailiban.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bailiban.domain.Book;
import com.bailiban.service.BookService;
import com.bailiban.service.impl.BookServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Servlet implementation class CheckBookServlet
 */
@WebServlet("/checkBook")
public class CheckBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 //1.��ȡ����
        String name = request.getParameter("name");

        //2.����service���ж������Ƿ����
        BookService BookService = new BookServiceImpl();
        Book book = BookService.findBookByName(name);
        
        //������Ӧ�����ݸ�ʽΪjson
        response.setContentType("application/json;charset=utf-8");
        Map<String,Object> map = new HashMap<String,Object>();

        if(book!=null){
            //����
            map.put("isExsit",true);
            map.put("msg","*�����Ѿ�����");
        }else{
            //������
            map.put("isExsit",false);
            map.put("msg","*��������");
        }

        //��mapתΪjson�����Ҵ��ݸ��ͻ���
        //��mapתΪjson
        ObjectMapper mapper = new ObjectMapper();
        //���Ҵ��ݸ��ͻ���
        mapper.writeValue(response.getWriter(),map);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
