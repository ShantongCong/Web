package com.cong.web;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cookie_access")
public class CookieAccessServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //设置一个 localhost:8080 也能够发送到的Cookie
        Cookie deep = new Cookie("deepPath", "deepCookieValue");
        deep.setPath("/");
        response.addCookie(deep);

        //设置一个只有在当前路径才能访问的Cookie

        Cookie context = new Cookie("ContextPath", "ContextCookieValue");
        context.setPath(request.getContextPath());
        //System.out.println(request.getContextPath());
        response.addCookie(context);

//        Cookie shallow = new Cookie("shallowPath", "shallow");
//        shallow.setPath(request.getContextPath() + "/shallow");
//        response.addCookie(shallow);
        Cookie shallow = new Cookie("shallowPath", "shallowCookieValue");
        shallow.setPath(request.getContextPath() + "/shallow");
        response.addCookie(shallow);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
