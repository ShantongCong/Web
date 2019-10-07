package com.cong.email;

import com.itheima.utils.MailUtil;
import org.apache.commons.mail.EmailException;
import org.junit.Test;

/**
 * <h3>Project_Travel</h3>
 * <p>sent email test</p>
 *
 * @author : cong
 * @date : 2019-09-28 16:35
 **/
public class EmailTest {
    @Test
    public void test01(){
        try {
            MailUtil.sendEmail("congshantong@foxmail.com","张三","<h1>点击激活</h1><a href=\"http://localhost:8080/user?action=active\">确实</a>");
        } catch (EmailException e) {
            e.printStackTrace();
        }
    }
}
