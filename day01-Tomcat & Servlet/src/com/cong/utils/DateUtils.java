package com.cong.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <h3>day01-Tomcat & Servlet</h3>
 * <p>日期工具类</p>
 *
 * @author : cong
 * @date : 2019-09-10 21:08
 **/
public class DateUtils {
    // 传入一个格式化的日期字符串(yyyy-MM-dd)，返回一个Date
    public static Date transStringToDate(String stringDate) {
        Date parse=null;
        try {
             parse = new SimpleDateFormat("yyyy-MM-dd").parse(stringDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return parse;
    }
    // 传入一个Date对象，返回一个格式化后的字符串
    public static String transDateToString(Date date) {
        return new SimpleDateFormat("yyyy-MM-dd").format(date);
    }

    // 传入一个1970-01-01毫秒数，返回一个格式化后的字符串
    public static String transDateToString(long date) {
        return new SimpleDateFormat("yyyy-MM-dd").format(date);
    }

}
