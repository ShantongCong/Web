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

@WebServlet("/query_contacts_page")
public class QueryContactsPageServlet extends HttpServlet {
    private ContactInfoService service = new ContactInfoServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");

        //1.接收数据
        //页面大小
        int pageSize=10;
        String pageSize1 = request.getParameter("pageSize");
        if (pageSize1!=null) {
            pageSize=Integer.parseInt(pageSize1);
        }


        //    currentPage 当前页面
        int currentPage=1;
        String page = request.getParameter("currentPage");
        if (page!=null){
        currentPage = Integer.parseInt(page);
        }

        //2.处理数据
        // pageOff 页面开始的第一个行的行数

        //获得总页面
        int count = service.queryRecordCount();
        int ceil = (int)Math.ceil(count / (double) pageSize);

        int pageOff = (currentPage - 1) * pageSize;
        List<ContactInfo> contactInfos= service.queryPage(pageOff,pageSize);
        request.setAttribute("contacts",contactInfos);
        request.setAttribute("currentPage",currentPage);
        request.setAttribute("pageSize",pageSize);
        request.setAttribute("pageCount",ceil);


        //获得当前页面


        //3.响应数据

        request.getRequestDispatcher("/list.jsp").forward(request,response);






//        // 1. 接收数据
//        int currentPage = 1;
//        String currentPageParam = request.getParameter("currentPage");
//        if (currentPageParam != null) {
//            currentPage = Integer.parseInt(currentPageParam);
//        }
//
//        int pageSize = 10;
//        String pageSizeParam = request.getParameter("pageSize");
//        if (pageSizeParam != null) {
//            pageSize = Integer.parseInt(pageSizeParam);
//        }
//
//        int pageOffset = (currentPage - 1) * pageSize;
//
//        // 一共有多少条记录
//        int recordCount = service.queryRecordCount();
//
//        // 一共有多少页
//        int pageCount = (int)Math.ceil(recordCount / (double)pageSize);
//
//        // 2. 处理数据
//        List<ContactInfo> contacts = service.queryPage(pageOffset, pageSize);
//        request.setAttribute("contacts", contacts);
////        request.setAttribute("pageCount", pageCount);
////        request.setAttribute("currentPage", currentPage);
////        request.setAttribute("pageSize", pageSize);
//
//        // 3. 响应数据
//        request.getRequestDispatcher("/list.jsp").forward(request, response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
