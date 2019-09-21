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

@WebServlet("/update_contact_broker")
public class UpdateContactBroker extends HttpServlet {
    private ContactInfoService service = new ContactInfoServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");

        // 1. 接收数据
        String id = request.getParameter("id");

        // 2, 处理数据
        ContactInfo contact =  service.queryContactById(id);

        // 此servlet，需要给add.jsp准备数据
        // 那么需要把一个数据，放到一个域当中
        // 从小往大考虑
        // 结论：用请求域
        // 理由：在servlet里面，往请求域当中放
        //       在jsp里面从请求域当中取
        request.setAttribute("contact", contact);

        // 3. 响应数据
        // 跳转技术：转发和重定向，如果重定向搞不定的话，使用转发
        // 结论：使用转发
        // 理由：因为数据存储在了请求域当中，如果使用重定向的话，对于浏览器来说，是两次请求
        //       第二次请求的时候，前一次放在请求域当中的数据，会被销毁
        //       所以，重定向搞不定，使用转发
        request.getRequestDispatcher("/update.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
