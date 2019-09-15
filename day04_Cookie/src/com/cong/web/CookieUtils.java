package com.cong.web;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * <h3>day04_Cookie</h3>
 * <p>Cookie工具类</p>
 *
 * @author : cong
 * @date : 2019-09-15 17:02
 **/
public class CookieUtils {
    public static String getCookieValue(HttpServletRequest request, String name){
        Cookie[] cookies = request.getCookies();
        if (cookies==null) return null ;

        for (Cookie cookie : cookies) {
            if (cookie.getName().equals(name))
                return cookie.getValue();
        }
        return null;


    }
}
