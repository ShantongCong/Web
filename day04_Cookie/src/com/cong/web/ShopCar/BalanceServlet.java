package com.cong.web.ShopCar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/balance")
public class BalanceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");


        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter();

        List<String> goods = (List<String>)session.getAttribute("good");
        if (goods!=null){
            out.println("<h1>您好，以下是您在购物车当中的商品</h1>");
        for (String good : goods) {
            out.write("<h2>"+good+"</h2>");
        }
        }else {
            System.out.println("==");
        }

  }





    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
