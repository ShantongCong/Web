package com.itheima.web;

import com.itheima.service.ContactInfoService;
import com.itheima.service.impl.ContactInfoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/update_contact")
public class UpdateContactServlet extends HttpServlet {
    ContactInfoService service= new ContactInfoServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        //1.请求数据
        Map<String, String[]> parameterMap = request.getParameterMap();
        //2.处理数据
        service.modifyContact(parameterMap);
        //3.响应数据
        response.sendRedirect("/query_contacts_page");


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
