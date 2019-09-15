package com.cong.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/character_stream")
public class CharacterStreamServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //使用utf-8进行字符编码
        //response.setCharacterEncoding("utf-8");

        //告诉浏览器字符编码的解码格式
        response.setContentType("text/html; charset=utf-8");
        PrintWriter out=response.getWriter();
        out.write("<html>");
        out.write("<head>");
        out.write("<title>Hello My First Response</title>");
        out.write("</head>");
        out.write("<body>");
        out.write("<h1>Hello World!!!</h1>");
        out.write("<h1>你好!世界我是你爹！</h1>");
        out.write("</body>");
        out.write("</html>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doPost(request,response);
    }
}
