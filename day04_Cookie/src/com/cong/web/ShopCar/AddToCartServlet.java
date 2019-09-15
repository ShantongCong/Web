package com.cong.web.ShopCar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet("/add_to_cart")
public class AddToCartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");


        //获取这次请求发过来的商品
        String[] paramGoods = request.getParameterValues("good");

        HttpSession session = request.getSession();
        //从会话域获得之前添加到购物车里的商品
        List<String> goods = (ArrayList<String>)session.getAttribute("good");
        //可能第一次提交商品，session中没有任何数据
        //没有数据应该线创建一个
        if (goods==null){
            goods=new ArrayList<>();
        }

        if (paramGoods!=null){
            List<String> list = Arrays.asList(paramGoods);
            goods.addAll(list);
        }
        session.setAttribute("good",goods);

        for (String good : goods) {
            System.out.println(good);
        }

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
