package com.cong.web;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * <h3>day01-Tomcat & Servlet</h3>
 * <p>通过注解创建服务端</p>
 *
 * @author : cong
 * @date : 2019-09-10 16:56
 **/
@WebServlet({"/anno","/annotation"}/*,name = "AnnotationServlet"*/)
public class AnnotationServlet implements Servlet{
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

        System.out.println("通过注解创建Servlet类");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}
