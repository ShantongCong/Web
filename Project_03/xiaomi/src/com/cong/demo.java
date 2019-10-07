package com.cong;

/**
 * <h3>xiaomi</h3>
 * <p>小米税后</p>
 *
 * @author : cong
 * @date : 2019-10-07 12:13
 **/
public class demo {
    public static void main(String[] args) {
        double count = 0;
        for (int i = 1; i < 11; i++) {
            double yealM = 300 * (1 + (1.0 / i));
            count = count + yealM;
            System.out.println("第" + i + "个月:" + yealM);
        }
        System.out.println("count = " + count);


        int i = 3000;
        double v = (count - i) / i;

        System.out.println("十个月利率为 = " + v);
        System.out.println("年利率为 = " + v * 6 / 5);


    }


}
