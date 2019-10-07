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

        return dao.insert(user)==1;
    }

    private void generateCode(User user) {
        user.setCode(UUIDUtil.getUuid());
    }
}
