package com.bailiban.web.listener;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;


/**
 * 
 * @author my
 * ����һ��ServletContextListener ������ 
 * ����ServletContext�Ĵ���������
 */
@WebListener
public class MyServletContextListener implements ServletContextListener {
    
	 /*
     * ���� ServletContext����Ĵ���
     * ServletContext�������ڷ������������Զ�����
     * �÷����ڷ������������Զ�����
     * 
     */
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		
		 System.out.println("ServletContext���󱻴����ˡ�����");
		 //������·�� classpath�µ������ļ�
		 //�õ�servletContext����
		 ServletContext servletContext = sce.getServletContext();
		 //��ȡ���ò���
		 String contextConfigLocation = servletContext.getInitParameter("contextConfigLocation");
		 //��ȡ��ʵ·��
		 String realPath = servletContext.getRealPath(contextConfigLocation);
		 System.out.println(realPath);
		 //���ļ����ؽ��ڴ�
		 try {
			FileInputStream fis = new FileInputStream(realPath);
			System.out.println(fis) ;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
    /*
     * �ڷ������رպ�ServletContext�������١�
     * �������������رպ�÷���������
     * 
     */
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		
		System.out.println("ServletContext���������ˡ�����");
		
	}
 
	
}
