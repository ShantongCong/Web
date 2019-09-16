package com.cong;

/**
 * <h3>day02-HTTP&Request</h3>
 * <p>用户信息类</p>
 *
 * @author : cong
 * @date : 2019-09-16 16:54
 **/
public class UserInfo {
    private String username;
    private String password;

    public UserInfo() {
    }

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
