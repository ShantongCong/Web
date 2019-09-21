package com.itheima.web;

import com.itheima.domain.ContactInfo;
import com.itheima.service.ContactInfoService;
import com.itheima.service.impl.ContactInfoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/query_contacts")
public class QueryContactsServlet extends HttpServlet {
    private ContactInfoService service = new ContactInfoServiceImpl();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        //1.接受数据

        //2.处理数据
        List<ContactInfo> contactInfos =service.queryAll();
        request.setAttribute("contacts",contactInfos);

        //3.相应数据
        request.getRequestDispatcher("/list.jsp").forward(request,response);








 //        request.setCharacterEncoding("utf-8");
//        response.setContentType("text/html; charset=utf-8");
//
//        // 1. 接收数据
//
//        // 2. 处理数据
//        List<ContactInfo> contacts = service.queryAll();
//        request.setAttribute("contacts", contacts);
//
//        // 3. 响应数据
//        request.getRequestDispatcher("/list.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
