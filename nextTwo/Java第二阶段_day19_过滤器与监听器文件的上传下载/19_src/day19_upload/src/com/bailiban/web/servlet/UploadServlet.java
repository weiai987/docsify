package com.bailiban.web.servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet("/upload")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// ����һ��DiskFileItemfactory������
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// ����һ��ServletFileUpload���Ķ���
		ServletFileUpload sfu = new ServletFileUpload(factory);
		// ����ϴ��ļ�����������
		sfu.setHeaderEncoding("utf-8");

		// ����request���󣬲��õ�һ������ļ���
		try {
			List<FileItem> fileItems = sfu.parseRequest(request);
			// ������������
			for (FileItem fileitem : fileItems) {
				// �������ͨ����
				if (fileitem.isFormField()) {
					// �������
					// ��ȡ�ÿؼ���valueֵ
					String value = fileitem.getString("utf-8");
					// ��ȡ�ÿؼ���name����ֵ
					String name = fileitem.getFieldName();
					System.out.println(name + "--" + value);
				} else {

					// �ϴ��ļ�
					uploadFile(fileitem);
				}
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	// ���ϴ��ļ������װ
	private void uploadFile(FileItem fileItem) {
		// ����ϴ�����
		// �õ��ļ�������
		// ��������Ŀ¼·��
		String realPath = this.getServletContext().getRealPath("/upload");
		// ���ݸ�·������һ��Ŀ¼����
		File dir = new File(realPath);
		if (!dir.exists()) {
			dir.mkdirs();// ����һ��ָ����Ŀ¼
		}
		// �õ��ϴ�������
		String filename = fileItem.getName();// ��Ů.jpg
		if (filename != null) {
			// �õ��ļ���׺
			String extend = filename.substring(filename.indexOf("."));
			System.out.println(extend);
			// ��д����һ��Ψһ���ļ���
			filename = UUID.randomUUID() + extend;
		}
		// Ŀ¼����
		String childDir = getChildDir(filename);
		// �ϴ��ļ�,�Զ�ɾ����ʱ�ļ�
		try {
			fileItem.write(new File(realPath, childDir + "/" + filename));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// Ŀ¼��������
	private String getChildDir(String filename) {

		// ��ȡ�ļ�����hashCode
		int hashCode = filename.hashCode();
		// ת��Ϊ16����
		String code = Integer.toHexString(hashCode);
		// ȡǰ2���ַ�ƴ��һ����Ŀ¼
		String childDir = code.charAt(0) + "/" + code.charAt(1);
		return childDir;
	}

}
