package com.cong.web.HomeWork;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/resource_a")
public class ResourceAServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        System.out.println("AServlet接收到了用户的请求");
        PrintWriter out = response.getWriter();
        out.println("<h2>三秒过后跳转黄色网站！请脱好裤子，备好纸巾！</h2>");

        try {
            Thread.sleep(3000);
            System.out.println("123");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
            request.getRequestDispatcher("/resource_b").forward(request, response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doPost(request, response);
    }
}
