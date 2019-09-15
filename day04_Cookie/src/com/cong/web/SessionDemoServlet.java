package com.cong.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

@WebServlet("/session_demo")
public class SessionDemoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        //获取session
        HttpSession session = request.getSession();
        out.println("Session Id:"+session.getId()+"</br>");
        out.println("Creation Time:"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(session.getCreationTime())+"</br>");
        Timestamp timestamp = new Timestamp(session.getCreationTime());
        out.println("last accessed time :"+timestamp+"</br>");
        out.println("Is New: "+session.isNew()+"</br>");
        out.println("Servlet Context: " + session.getServletContext() + "</BR>");
        //设置最大非活动时间
        session.setMaxInactiveInterval(10);




    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
