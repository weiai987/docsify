package com.blb.bookms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * 下载控制器
 */
@Controller
public class DownloadController {

    @RequestMapping("download")
    public void download(String file,  HttpServletResponse response) throws IOException {
        //下载文件的路径
        String path = "D:\\install\\";
        File downFile = new File(path+file);
        if(downFile.exists()){
            //设置浏览器下载内容类型，响应头
            response.setContentType("application/x-msdownload");
            response.setHeader("Content-Disposition","attachment;filename="+file);
            //通过流发送文件
            Files.copy(downFile.toPath(),response.getOutputStream());
        }
    }
}
