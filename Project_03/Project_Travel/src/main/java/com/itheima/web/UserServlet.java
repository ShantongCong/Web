package com.itheima.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itheima.domain.User;
import com.itheima.service.UserService;
import com.itheima.service.imp.UserServiceImp;
import com.itheima.utils.MailUtil;
import com.sun.xml.internal.bind.v2.TODO;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.mail.EmailException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/user")
public class UserServlet extends ActionServlet {
    private UserService service = new UserServiceImp();

    protected void active(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("UserServlet active invoked !");
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

        if (service.existEmail(email)){
            //邮箱已存在
            result.put("code",1);
            result.put("msg","邮箱已存在");

        }else if (!service.captchaValid(request,captcha)){
            //验证码错误
            result.put("code",2);
            result.put("msg","验证码错误");
        }else {
            service.insert(parameterMap);

            result.put("code",0);
            result.put("msg","操作成功！");
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
}
