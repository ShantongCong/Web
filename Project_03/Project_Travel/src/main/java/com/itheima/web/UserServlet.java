package com.itheima.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itheima.domain.User;
import com.itheima.service.UserService;
import com.itheima.service.imp.UserServiceImp;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/user")
public class UserServlet extends ActionServlet {
    private UserService service = new UserServiceImp();

    protected void active(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("UserServlet active invoked  账号已激活!");
        response.setContentType("text/html;charset=utf-8");

        //激活
        String code = request.getParameter("code");

        service.active(code);

        //三面后跳转页面
        response.getWriter().write("<h1>账号已激活三秒后跳转到注册页面</h1>");
        //TODO 激活邮箱三秒后不会跳转到登录页面：可能和版本不兼容，方法的参数变量化名都不一样
        response.setHeader("Refresh", "3;url=http://localhost:8080/login.html");


    }

    protected void checkEmail(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("UserServlet checkEmail invoked !");
        //检查邮箱是否已经存在
        //因为返回的参数是给Jquery-validation使用的，需要得到的响应式true或者是false
        response.setContentType("text/plain;charset=utf-8");

        String email = request.getParameter("email");

        if (service.existEmail(email)) {
            response.getWriter().write("false");
            System.out.println("已存在");
        } else {
            response.getWriter().write("true");
            System.out.println("未存在");
        }


    }

    protected void register(HttpServletRequest request, HttpServletResponse response) throws JsonProcessingException {
        //System.out.println("UserServlet register invoked !");'
        System.out.println("调用到了这里！");
        //TODO 没有做注册的处理！
        //同步请求！？

        Map<String, String[]> parameterMap = request.getParameterMap();
        String email = request.getParameter("email");
        String captcha = request.getParameter("captcha");

        Map<String, Object> result = new HashMap<>();

        if (service.existEmail(email)) {
            //邮箱已存在
            result.put("code", 1);
            result.put("msg", "邮箱已存在");

        } else if (!service.captchaValid(request, captcha)) {
            //验证码错误
            result.put("code", 2);
            result.put("msg", "验证码错误");
        } else {
            service.insert(parameterMap);

            result.put("code", 0);
            result.put("msg", "操作成功！");
        }

        HttpSession session = request.getSession();
        session.removeAttribute("captcha");


        response.setContentType("application/json;charset=utf-8");

        ObjectMapper mapper = new ObjectMapper();
        String resultJson = mapper.writeValueAsString(result);
        try {
            response.getWriter().write(resultJson);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("application/json;charset=utf-8");

        HashMap<String, Object> result = new HashMap<>();

        //获取参数
        String captcha = request.getParameter("captcha");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        User user = service.queryByEmailAndPassword(email, password);

        //TODO 前端验证码矫正
        //进行验证
        if (!service.captchaValid(request, captcha)) {
            //验证码是否正确
            result.put("code", "1");
            result.put("msg", "验证码错误请重新输入");
        } else if (user == null) {
            //账号密码是否正确
            result.put("code", "2");
            result.put("msg", "账号密码错误请重新输入");
        } else if (service.IsActiveValid(user)) {
            result.put("code", "3");
            result.put("msg", "账号未激活，请点击邮箱内链接进行激活！");
        } else {
            //operate success
            result.put("code", "0");
            result.put("msg", "operate success!");
            request.getSession().setAttribute("user", user);
        }

        //帐号是否激活

        //刷新验证码
        request.getSession().removeAttribute("captcha");
        ObjectMapper mapper = new ObjectMapper();
        String string = mapper.writeValueAsString(result);
        response.getWriter().write(string);
    }

    protected void queryCurrentUser(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("application/json;charset=utf-8");
        HashMap<String, Object> result = new HashMap<>();

        //是否需要强转？
        Object user = request.getSession().getAttribute("user");

        if (user == null) {
            result.put("code", 1);
            result.put("msg", "用户未登录");
        } else {
            result.put("code", 0);
            result.put("msg", "用户已登录");
            result.put("user", user);
        }

        ObjectMapper mapper = new ObjectMapper();
        String string = mapper.writeValueAsString(result);
        response.getWriter().write(string);
    }

    protected void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {

        //清除缓存中的用户数据
        request.getSession().removeAttribute("user");

        //使用重定向 跳转到登录界面
        response.sendRedirect("login.html");
    }
}
