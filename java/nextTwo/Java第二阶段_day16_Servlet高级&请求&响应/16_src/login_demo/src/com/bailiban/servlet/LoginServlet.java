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

import com.bailiban.domain.User;
import com.bailiban.service.UserService;
import com.bailiban.service.impl.UserServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  
		//ʹ��request������ post �ύ��������
		request.setCharacterEncoding("utf-8");
//		//ʹ��request����  ���ձ��ύ������
//		//getParameter(String name)  nameΪ���ռ���name����ֵ
//		String username = request.getParameter("username");
//		String password = request.getParameter("password");
//		//���յ������ݷ�װ���û�����
//		User loginUser  = new User(username, password);
		//ʹ��BeanUtils�Ż������ķ�װ
		//��ȡ�����������
		Map<String, String[]> map = request.getParameterMap();
		//���������ݷ�װ��ʵ����
		User loginUser = new User();
		try {
			BeanUtils.populate(loginUser, map);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		//ʵ����UserService����
		UserService userService = new UserServiceImpl();
		//���õ�¼����  �õ������ݿ��в�ѯ���û�����
		User user = userService.login(loginUser);
		//�ж��û��Ƿ��¼�ɹ�
		if(user!=null) {
			//�����¼�ɹ� �ض��� SuccessServlet
			//request.getContextPath() ��ȡ����Ŀ¼
			response.sendRedirect(request.getContextPath()+"/success");
			
		}else {
			//���ִ��� ��request���зŴ�����Ϣ
			request.setAttribute("msg", "�û���Ϊ��"+loginUser.getUsername()+" ����Ϊ:"+loginUser.getPassword()+" ���û���¼ʧ��");
			//ת����ErrorServlet ��ʾ������ʾ
			request.getRequestDispatcher("/error").forward(request, response);
			
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//������get����post���� ��ִ��doGet����   ����д�ظ��Ĵ���
		doGet(request, response);
	}

}
