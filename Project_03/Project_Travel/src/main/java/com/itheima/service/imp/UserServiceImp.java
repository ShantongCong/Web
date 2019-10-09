package com.itheima.service.imp;

import com.itheima.dao.UserDAO;
import com.itheima.dao.imp.UserDAOImp;
import com.itheima.domain.User;
import com.itheima.service.UserService;
import com.itheima.utils.MailUtil;
import com.itheima.utils.UUIDUtil;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.mail.EmailException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Map;

/**
 * <h3>Project_Travel</h3>
 * <p></p>
 *
 * @author : cong
 * @date : 2019-10-07 19:58
 **/
public class UserServiceImp implements UserService {
    private UserDAO dao = new UserDAOImp();

    @Override
    public boolean existEmail(String email) {
        List<User> users = dao.queryByEmail(email);
        if (users.size() == 1) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean captchaValid(HttpServletRequest request, String captcha) {
        HttpSession session = request.getSession();
        String sessionCaptcha = (String) session.getAttribute("captcha");

        return captcha.equalsIgnoreCase(sessionCaptcha);
    }

    @Override
    public boolean insert(Map<String, String[]> parameterMap) {
        User user = new User();
        try {
            //把Map封装成对象
            BeanUtils.populate(user, parameterMap);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //生成校验码
        generateCode(user);

        //发送邮件
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<h1>点击以下链接激活你的账户<h1>");
        stringBuilder.append("<a href=\"http://localhost:8080/user?action=active");
        stringBuilder.append("&code=");
        stringBuilder.append(user.getCode());
        stringBuilder.append("\">激活按钮</a>");

        try {
            MailUtil.sendEmail(user.getEmail(), user.getRealname(), stringBuilder.toString());
        } catch (EmailException e) {
            e.printStackTrace();
        }
        //插如数据库

        return dao.insert(user) == 1;
    }

    @Override
    public boolean active(String code) {
        return dao.activeCode(code) == 1;

    }

    @Override
    public User queryByEmailAndPassword(String email, String password) {
        List<User> users = dao.queryByEmail(email);

        //调试使用
        //String password1 = users.get(0).getPassword();
        //System.out.println("password = " + password);
        //System.out.println(password1);
        //未查找到改用户
        //密码错误
        System.out.println();
        if (users.size() == 1 && users.get(0).getPassword().equals(password)) {
            return users.get(0);
        } else return null;
    }

    @Override
    public boolean IsActiveValid(User user) {
        return user.getStatus() == 0;
    }

    private void generateCode(User user) {
        user.setCode(UUIDUtil.getUuid());
    }
}
