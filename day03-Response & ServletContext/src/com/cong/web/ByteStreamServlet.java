package com.cong.web;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

@WebServlet("/byte_stream")
public class ByteStreamServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html; charset=utf-8");
        response.setHeader("Content-Disposition", "attachment;filename=小鸟酱.avi");
        OutputStream out = response.getOutputStream();
        //InputStream in = new FileInputStream("D:\\download.jpg");
        InputStream in = new FileInputStream("D:\\ServletTest\\video.wmv");
        //InputStream in = new FileInputStream("D:\\ServletTest\\artist.jpg");

//        byte[] buff = new byte[1024];
//        int len;
//        while ((len = in.read(buff)) != -1) {
//            out.write(buff, 0, len);
//        }
        IOUtils.copy(in,out);

        out.close();
        in.close();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doPost(request, response);
    }
}
