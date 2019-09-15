package com.cong.web;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@WebServlet("/download")
public class DownloadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取前端发过来的文件名参数
        response.setHeader("Content-Disposition", "attachment;filename=1.gif");
        //使用字节流，制作图片下载
        OutputStream out = response.getOutputStream();
        //获取项目中当中的WEB-INF下面
        ServletContext context = getServletContext();
        String realPath = context.getRealPath("WEB-INF");
        InputStream in = new FileInputStream(realPath);
        IOUtils.copy(in, out);

        in.close();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
