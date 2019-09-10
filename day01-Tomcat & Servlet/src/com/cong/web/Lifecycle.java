package com.cong.web;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;

/**
 * <h3>day01-Tomcat & Servlet</h3>
 * <p>测试Servlet声明周期</p>
 *
 * @author : cong
 * @date : 2019-09-10 17:26
 **/
@WebServlet("/lifecycle")
public class Lifecycle implements Servlet{
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("servlet被创建了");
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

        System.out.println("生命周期Servlet被调用了！");
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("生命周期Servlet被销毁了！");

    }
}
