package com.blb.servlet;

import com.blb.entity.UserFile;
import com.blb.service.IUserFileService;
import com.blb.service.impl.UserFileServiceImpl;
import com.blb.utils.SessionUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/index/*")
public class IndexServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private IUserFileService userFileService = new UserFileServiceImpl();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pathName = req.getParameter("pathName");
		pathName = pathName==null?"/":pathName;
		req.getSession().setAttribute("pathName", pathName);
		try {
			List<UserFile> list = userFileService.getFiles(SessionUtils.getUserId(req), pathName);
			req.setAttribute("list", list);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}
	
	
}
