package com.cong.web.login_ver_2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login_ver_2")
public class Login_ver_2Servlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        UserInfo userInfo = new UserInfo();

        String username = request.getParameter("username");
        userInfo.setUsername(username);
        String password = request.getParameter("password");
        userInfo.setPassword(password);
        if ("user".equals(userInfo.getUsername())&&"pass".equals(userInfo.getPassword())){
            request.getRequestDispatcher("login_success").forward(request,response);
        }else {
            request.getRequestDispatcher("login_failure").forward(request,response);
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
