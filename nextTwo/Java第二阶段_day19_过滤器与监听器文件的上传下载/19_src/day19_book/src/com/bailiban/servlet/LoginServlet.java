package com.bailiban.servlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import com.bailiban.domain.User;
import com.bailiban.service.UserService;
import com.bailiban.service.impl.UserServiceImpl;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  
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
			 //��Ӽ�ס�û�������
			 //��ȡ��ѡ���ֵ
			String remember = request.getParameter("remember");
			//�����ѡ��
			if(remember!=null){
				
				//����Cookie�����û���
				Cookie cookie  = new Cookie("username",user.getUsername());
				//���ñ���ʱ��
				cookie.setMaxAge(60*60*24*30);//30��
				//����cookie�������
				response.addCookie(cookie);
				
			}else {
				//���û�й�ѡ
				//��ȡcookie 
				Cookie[] cookies = request.getCookies();
				if(cookies!=null) {
					
					for (Cookie c : cookies) {
						
						//�ҵ�nameΪusername��cookie
						 if("username".equals(c.getName())) {
							 
							 //ɾ����cookie
							 c.setMaxAge(0);
							 //���͵������
							 response.addCookie(c);
							 break;
						 }
						
					}
					
				}
				
			}
			
			//�û���¼�ɹ��� �����û���¼״̬ ���û����󱣴浽session��
			 HttpSession session = request.getSession();
			 session.setAttribute("u", user);
			//�ض��� ͼ���б�ҳ��
			response.sendRedirect(request.getContextPath()+"/book/list");
			
		}else {
			//���ִ��� ��request���зŴ�����Ϣ
			request.setAttribute("msg", "�û���¼ʧ��!!!");
			//ת����login.jsp ��ʾ������ʾ
			request.getRequestDispatcher("/login.jsp").forward(request, response);
			
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//������get����post���� ��ִ��doGet����   ����д�ظ��Ĵ���
		doGet(request, response);
	}

}
