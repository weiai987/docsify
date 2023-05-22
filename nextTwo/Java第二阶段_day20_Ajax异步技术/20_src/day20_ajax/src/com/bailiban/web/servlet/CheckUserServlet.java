package com.bailiban.web.servlet;

import com.bailiban.domain.User;
import com.bailiban.service.UserService;
import com.bailiban.service.impl.UserServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/checkUser")
public class CheckUserServlet extends HttpServlet {
  
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.��ȡ�û���
        String username = request.getParameter("username");

        //2.����service���ж��û����Ƿ����
        UserService userService = new UserServiceImpl();
        User user = userService.findUserByUserName(username);
        
        //������Ӧ�����ݸ�ʽΪjson
        response.setContentType("application/json;charset=utf-8");
        Map<String,Object> map = new HashMap<String,Object>();

        if(user!=null){
            //����
            map.put("isExsit",true);
            map.put("msg","�û����Ѿ�����");
        }else{
            //������
            map.put("isExsit",false);
            map.put("msg","�û�������");
        }

        //��mapתΪjson�����Ҵ��ݸ��ͻ���
        //��mapתΪjson
        ObjectMapper mapper = new ObjectMapper();
        //���Ҵ��ݸ��ͻ���
        mapper.writeValue(response.getWriter(),map);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
