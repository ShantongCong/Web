package com.cong.web;

import com.cong.domain.ContactInfo;
import com.cong.service.ContactInfoService;
import com.cong.service.ContactInfoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/query_contacts")
public class QueryContactsServlet extends HttpServlet {
    // 成员变量定义，因为类当中的方法，很多都有可能使用service,所以定义要放到成员变量当中
    private ContactInfoService service = new ContactInfoServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 组装通讯录列表
        List<ContactInfo> contactInfoList = service.queryAll();

        // 打印输出
        for (ContactInfo contactItem : contactInfoList) {
            System.out.println(contactItem);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

