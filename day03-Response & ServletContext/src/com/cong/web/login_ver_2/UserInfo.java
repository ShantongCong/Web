package com.cong.web.login_ver_2;

/**
 * <h3>day03-Response & ServletContext</h3>
 * <p>用户信息javabean</p>
 *
 * @author : cong
 * @date : 2019-09-16 15:32
 **/
public class UserInfo {
    private String username;
    private String password;

    public UserInfo() {
    }

    //一旦有了其他构造方法，会把默认的空参构造访问类型变成私有类型
    public UserInfo(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
