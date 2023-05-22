package com.bailiban.web.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sun.misc.BASE64Encoder;

@WebServlet("/download")
public class DownloadServlet extends HttpServlet {
  
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //��ȡ����������ļ�����
        String filename = request.getParameter("filename");
        //ʹ���ֽ������������ļ����ڴ�
        //�ҵ��ļ�������·��
        ServletContext servletContext = this.getServletContext();
        String realPath = servletContext.getRealPath("/" + filename);
        //�����ֽ���
        FileInputStream fis = new FileInputStream(realPath);
        //����response����Ӧͷ
        //������Ӧͷ���ͣ�content-type
        String mimeType = servletContext.getMimeType(filename);//��ȡ�ļ���mime����
        response.setHeader("content-type",mimeType);
        //������Ӧͷ�򿪷�ʽ:content-disposition
        //����������������
       //1.��ȡuser-agent����ͷ��
        String agent = request.getHeader("user-agent");
        //2.����ͷ��Ϣ�ж�
        if (agent.contains("MSIE")) {
            // IE�����
            filename = URLEncoder.encode(filename, "utf-8");
            filename = filename.replace("+", " ");
        } else if (agent.contains("Firefox")) {
            // ��������
            BASE64Encoder base64Encoder = new BASE64Encoder();
            filename = "=?utf-8?B?" + base64Encoder.encode(filename.getBytes("utf-8")) + "?=";
        } else {
            // ���������
            filename = URLEncoder.encode(filename, "utf-8");
        }
        response.setHeader("content-disposition","attachment;filename="+filename);
        //��������������д�����������
        ServletOutputStream sos = response.getOutputStream();
        byte[] buff = new byte[1024 * 8];
        int len = 0;
        while((len = fis.read(buff)) != -1){
            sos.write(buff,0,len);
        }

        fis.close();
        sos.close();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
