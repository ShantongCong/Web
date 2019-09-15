package com.cong.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/access_time")
public class AccessTimeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html; charset=utf-8");
        Cookie lastVisit;
        //
        String nowTime;

        PrintWriter out = response.getWriter();
        String lastVisitTime = CookieUtils.getCookieValue(request, "LastVisit");

        if (lastVisitTime==null){
            out.write("<h2>欢迎新司机！第一次访问！</h2>");
        }else {
            out.write("<2>欢迎老司机回顾</2>");
            out.write("<h2>上次访问的时间为："+lastVisitTime+"</h2>");
        }
        nowTime = new SimpleDateFormat("yyyy-MM-ddHH:mm:ss").format(new Date());
        lastVisit = new Cookie("LastVisit", nowTime);
        response.addCookie(lastVisit);
        out.write("<h2> 当前时间："+nowTime+"</h2>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
