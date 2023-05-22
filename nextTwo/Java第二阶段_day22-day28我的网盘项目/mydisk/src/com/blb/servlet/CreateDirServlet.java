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

@WebServlet("/createDir")
public class CreateDirServlet extends HttpServlet {

    private IUserFileService userFileService = new UserFileServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String pathName = req.getParameter("pathName");
            String name = req.getParameter("name");

            File file = new File(SessionUtils.getUploadPath(req) + pathName + "/" + name);
            if (file.exists()) {
                resp.getWriter().write(Response.error("目录名已存在"));
                return;
            }
            file.mkdir();


            UserFile userFile = new UserFile();
            userFile.setPathName(pathName);
            if (pathName.endsWith("/")) {
                pathName = pathName.substring(0, pathName.length()-1);
            }

            userFile.setFileName(pathName + "/" + name);
            userFile.setIsDir(0);
            userFile.setSubmitFileName(name);
            userFile.setUserId(SessionUtils.getUserId(req));
            userFileService.save(userFile);
            resp.getWriter().write(Response.success());
        } catch (SQLException e) {
            e.printStackTrace();
            resp.getWriter().write(Response.error(e.getMessage()));
        }
    }
}
