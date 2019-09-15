package com.cong.web.HomeWork;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
//把请求头显示在浏览器上
@WebServlet("/request_head")
public class RequestHeadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();


        Enumeration<String> headerNames = request.getHeaderNames();
        out.write("<h2>请求头参数如下</h2>");
        while (headerNames.hasMoreElements()) {
            String headerName=headerNames.nextElement();
            out.write("<h3>"+headerName+":"+request.getHeader(headerName)+"<h3>");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
