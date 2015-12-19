package com.wujie.weeklyreport.po;
/**
 * 用户类
 * @author wujie
 *
 */
public class User {
    
    private long id;
    private String loginName;
    private String userName;
    private String password;
    private int status;
    
    public String getLoginName() {
        return loginName;
    }
    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
	this.id = id;
    }
    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    
}
