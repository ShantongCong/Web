package com.cong.web.DownLoad_ver2;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@WebServlet("/download_simple")
public class DownloadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
//        response.setContentType("text/html;charset=utf-8");

        String filename = request.getParameter("filename");

        //获取输入流对象

        InputStream in = this.getServletContext().getResourceAsStream("/WEB-INF/" + filename);

        System.out.println("download:");
        String realPath = this.getServletContext().getRealPath("/WEB-INF/" + filename);
        System.out.println(realPath);
        //创建输出流

        OutputStream out = response.getOutputStream();
        //OutputStream out = response.getOutputStream();

        //IOUtils.copy(in,out);
        IOUtils.copy(in, out);

        in.close();
        out.close();


//        // 获取前端发过来的文件名参数
//        String filename = request.getParameter("filename");
//
//        // 告诉浏览器下载文件的文件名
//        response.setHeader("Content-Disposition", "attachment; filename=" + filename);
//
//        // 获取字节输出流
//        OutputStream out = response.getOutputStream();
//
//        // 获取文件的输入流对象
//        InputStream in = this.getServletContext().getResourceAsStream("/WEB-INF/" + filename);
//        System.out.println("Download:");
//        System.out.println(this.getServletContext().getRealPath("/WEB-INF/" + filename));
//        System.out.println();
//
//        // 利用IOUtils进行读取、写入
//        IOUtils.copy(in, out);
//
//        // 关闭流对象
//        in.close();
//        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
