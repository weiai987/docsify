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

		// 创建一个DiskFileItemfactory工厂类
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// 创建一个ServletFileUpload核心对象
		ServletFileUpload sfu = new ServletFileUpload(factory);
		// 解决上传文件名中文乱码
		sfu.setHeaderEncoding("utf-8");

		// 解析request对象，并得到一个表单项的集合
		try {
			List<FileItem> fileItems = sfu.parseRequest(request);
			// 遍历表单项数据
			for (FileItem fileitem : fileItems) {
				// 如果是普通表单项
				if (fileitem.isFormField()) {
					// 如果不是
					// 获取该控件的value值
					String value = fileitem.getString("utf-8");
					// 获取该控件的name属性值
					String name = fileitem.getFieldName();
					System.out.println(name + "--" + value);
				} else {

					// 上传文件
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

	// 将上传文件表单项封装
	private void uploadFile(FileItem fileItem) {
		// 如果上传表单项
		// 得到文件输入流
		// 创建物理目录路径
		String realPath = this.getServletContext().getRealPath("/upload");
		// 根据该路径创建一个目录对象
		File dir = new File(realPath);
		if (!dir.exists()) {
			dir.mkdirs();// 创建一个指定的目录
		}
		// 得到上传的名子
		String filename = fileItem.getName();// 美女.jpg
		if (filename != null) {
			// 得到文件后缀
			String extend = filename.substring(filename.indexOf("."));
			System.out.println(extend);
			// 重写生成一个唯一的文件名
			filename = UUID.randomUUID() + extend;
		}
		// 目录打撒
		String childDir = getChildDir(filename);
		// 上传文件,自动删除临时文件
		try {
			fileItem.write(new File(realPath, childDir + "/" + filename));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// 目录打撒方法
	private String getChildDir(String filename) {

		// 获取文件名的hashCode
		int hashCode = filename.hashCode();
		// 转换为16进制
		String code = Integer.toHexString(hashCode);
		// 取前2个字符拼成一个子目录
		String childDir = code.charAt(0) + "/" + code.charAt(1);
		return childDir;
	}

}
