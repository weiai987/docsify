package com.blb.servlet;

import com.blb.entity.UserFile;
import com.blb.service.IUserFileService;
import com.blb.service.impl.UserFileServiceImpl;
import com.blb.utils.IDUtils;
import com.blb.utils.IOUtils;
import com.blb.utils.Response;
import com.blb.utils.SessionUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@MultipartConfig
@WebServlet("/upload")
public class UploadServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private IUserFileService userFileService = new UserFileServiceImpl();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pathName = req.getParameter("pathName");
		try {
			List<UserFile> list = new ArrayList<>();
			
			Collection<Part> parts = req.getParts();
			for (Part part : parts) {
				if (part.getName().equals("files")) {
					String fileName = part.getSubmittedFileName();
					
					//生成新的文件名
					String suffix = fileName.substring(fileName.lastIndexOf("."), fileName.length());
					String newFileName = IDUtils.getID() + suffix;
					
					//保存文件
					InputStream inputStream = part.getInputStream();
					IOUtils.inputStreamToFile(inputStream, new File(SessionUtils.getUploadPath(req) + pathName + "/" + newFileName));
					
					UserFile userFile = new UserFile();
					userFile.setFileName(newFileName);
					userFile.setSubmitFileName(fileName);
					userFile.setUserId(SessionUtils.getUserId(req));
					userFile.setIsDir(1);
					userFile.setPathName(pathName);
					list.add(userFile);
				}
			}
			userFileService.saveList(list);
			resp.getWriter().write(Response.success());
		} catch (SQLException | IOException e) {
			e.printStackTrace();
			resp.getWriter().write(Response.error("文件上传失败"));
			return;
		}
	}
}
