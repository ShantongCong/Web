package com.itheima.web;

import com.itheima.service.ContactInfoService;
import com.itheima.service.impl.ContactInfoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/del_contact")
public class DelContactServlet extends HttpServlet {
    private ContactInfoService service = new ContactInfoServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");

        // 1. 接收数据
        String id = request.getParameter("id");

        // 2. 处理数据
        service.delContact(id);

        // 3. 响应数据
        response.sendRedirect("query_contacts_page");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
