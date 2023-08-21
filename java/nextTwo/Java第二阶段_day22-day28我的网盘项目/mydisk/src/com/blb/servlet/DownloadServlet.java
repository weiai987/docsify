package com.blb.servlet;

import com.blb.entity.UserFile;
import com.blb.service.IUserFileService;
import com.blb.service.impl.UserFileServiceImpl;
import com.blb.utils.SessionUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.sql.SQLException;

@WebServlet("/download")
public class DownloadServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private IUserFileService userFileService = new UserFileServiceImpl();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String id = req.getParameter("id");
			UserFile userFile = userFileService.getById(Integer.parseInt(id));
			FileInputStream fileInputStream = new FileInputStream(SessionUtils.getUploadPath(req) + userFile.getPathName() + userFile.getFileName());
			ServletOutputStream outputStream = resp.getOutputStream();

			resp.setContentLength(fileInputStream.available());
			resp.setContentType("application/octet-stream");
			resp.setHeader("content-disposition","attachment;filename="+ URLEncoder.encode(userFile.getSubmitFileName(),"UTF-8"));

			byte[] data = new byte[1024];
			int len;
			while ((len=fileInputStream.read(data))!=-1){
				outputStream.write(data, 0, len);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
