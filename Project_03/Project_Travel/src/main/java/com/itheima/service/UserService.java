package com.itheima.service;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * <h3>Project_Travel</h3>
 * <p></p>
 *
 * @author : cong
 * @date : 2019-10-07 19:57
 **/
public interface UserService {
    /**
     * 判断邮箱是否存在
     * @param email
     * @return 存在返回true  不存在赶回false
     */
    public boolean existEmail(String email);

    /**
     * 判断验证码
     * @param request 验证码所在的的session 要把能够获取session 的对象传过来
     * @param captcha 用户在表单中所填写的验证码
     * @return 检验成功 返回true
     */
    public boolean captchaValid(HttpServletRequest request, String captcha);

    /**
     * 向数据库中插入数据
     * 插入之前会生成激活码
     * 插入之后会发送邮件
     * @param parameterMap 表单数据
     * @return 成功返回true
     */
    public boolean insert(Map<String, String[]> parameterMap);
}
