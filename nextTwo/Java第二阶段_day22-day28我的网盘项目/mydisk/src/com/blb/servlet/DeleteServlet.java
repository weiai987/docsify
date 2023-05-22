package com.blb.servlet;

import com.blb.entity.UserFile;
import com.blb.service.IUserFileService;
import com.blb.service.impl.UserFileServiceImpl;
import com.blb.utils.Response;
import com.blb.utils.SessionUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/del")
public class DeleteServlet extends HttpServlet {

    private IUserFileService userFileService = new UserFileServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        try {
            UserFile userFile = userFileService.getById(Integer.parseInt(id));
            userFileService.del(Integer.parseInt(id));
            File file = new File(SessionUtils.getUploadPath(req) + userFile.getPathName() + userFile.getFileName());
            if (file.exists()) {
                file.delete();
            }
            resp.getWriter().write(Response.success());
        } catch (SQLException e) {
            e.printStackTrace();
            resp.getWriter().write(Response.error(e.getMessage()));
        }
    }
}
