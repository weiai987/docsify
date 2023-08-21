package com.bailiban.servlet;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.bailiban.domain.Book;
import com.bailiban.service.BookService;
import com.bailiban.service.impl.BookServiceImpl;


@WebServlet("/book/add")
public class BookAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// ����һ��DiskFileItemfactory������
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// ����һ��ServletFileUpload���Ķ���
		ServletFileUpload sfu = new ServletFileUpload(factory);
		// ����ϴ��ļ�����������
		sfu.setHeaderEncoding("utf-8");
		// ����request���󣬲��õ�һ������ļ���
		//���ڷ�װ��ͨ�����map 
		Map<String, String[]> map = new HashMap<String, String[]>();
		try {
			List<FileItem> fileItems = sfu.parseRequest(request);
			// ������������
			for (FileItem fileitem : fileItems) {
				// �������ͨ����
				if (fileitem.isFormField()) {
					// ��ȡ�ÿؼ���valueֵ
					String value = fileitem.getString("utf-8");
					// ��ȡ�ÿؼ���name����ֵ
					String name = fileitem.getFieldName();
					//��������ӵ�map
					map.put(name, new String[] {value});
				} else {

					// �ϴ��ļ�
					String filename = uploadFile(fileitem);
					//����ͼƬ��������ݵ�map��
					map.put(fileitem.getFieldName(), new String[] {filename});
				}
			}
			//����ͼ�����
			Book book  = new Book();
		    //�� map���ݷ�װ������
			BeanUtils.populate(book, map);
			//����service
			BookService bookService  = new BookServiceImpl();
			//������
			bookService.add(book);
			//��ӳɹ���ת��ͼ���б�ҳ��
			response.sendRedirect(request.getContextPath()+"/book/list");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	
		
		
	}
	// ���ϴ��ļ������װ
	//�����ļ�·��
	private String uploadFile(FileItem fileItem) {
		// ����ϴ�����
		// �õ��ļ�������
		// ��������Ŀ¼·��
		String realPath = this.getServletContext().getRealPath("/img");
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
			filename = new Date().getTime() + extend;
		}
		// Ŀ¼����
		String childDir = getChildDir(filename);
		//�õ��µ��ļ���
		filename = childDir + "/" + filename;
		try {
			// �ϴ��ļ�,�Զ�ɾ����ʱ�ļ�
			fileItem.write(new File(realPath, filename));
			return filename;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
