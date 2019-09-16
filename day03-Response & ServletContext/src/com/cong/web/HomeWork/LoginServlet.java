package com.cong.web.HomeWork;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        //使用getParameterMap方法 较为麻烦
//        Map<String, String[]> parameterMap = request.getParameterMap();
//        String[] usernames = parameterMap.get("username");
//        String[] passwords = parameterMap.get("password");
//        if ("name".equals(usernames[0])&&"pass".equals(passwords[0])){
//            System.out.println("登陆成功");
//            request.getRequestDispatcher("/login_success").forward(request,response);
//        }else {
//            request.getRequestDispatcher("/login_failure").forward(request,response);
//            System.out.println("登陆失败！");
//        }

        //较为成功 避免了空指针异常
        request.setCharacterEncoding("utf-8");

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (username.equals("user") && password.equals("pass")) {
            request.getRequestDispatcher("/login_success").forward(request, response);
        } else {
            request.getRequestDispatcher("/login_failure").forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
