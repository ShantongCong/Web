package com.itheima.web;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.itheima.domain.RoutePageBean;
import com.itheima.service.RouteService;
import com.itheima.service.imp.RouteServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/route")
public class RouteServlet extends ActionServlet {
    private RouteService service = new RouteServiceImpl();

    protected void distillation(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=utf-8");

        Map<String, Object> result = new HashMap<>();

        result.put("code", 0);
        result.put("msg", "operate success!");

        Map<String, Object> distillation = service.queryDistillation();
        result.put("distillation", distillation);

        ObjectMapper mapper = new ObjectMapper();
        String string = mapper.writeValueAsString(result);
        response.getWriter().write(string);
    }

    protected void queryPageRoutes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json;charset=utf-8");

        Map<String, Object> result = new HashMap<>();
        result.put("code",0);
        result.put("msg","operation success");

        RoutePageBean routePageBean=new RoutePageBean();
        //设置默认页数
        routePageBean.setCurrentPage(1);

        String currentPage = request.getParameter("currentPage");

        //按照cid分类查询
        String cid = request.getParameter("cid");

//        if (currentPage.equals("")){
//        System.out.println("测试使用 当前页数为默认页数");
//        }


        if (currentPage!=null&&!currentPage.equals("")){
            //获取请求中的页数
            routePageBean.setCurrentPage(Integer.parseInt(currentPage));
        }

        routePageBean.setPageSize(8);
        service.queryPage(cid,routePageBean);

        result.put("routePageBean",routePageBean);

        ObjectMapper mapper=new ObjectMapper();
        String string = mapper.writeValueAsString(result);
        response.getWriter().write(string);

    }


}
