package com.wujie.weeklyreport.service;

import java.util.List;

import com.wujie.weeklyreport.po.User;

public interface UserService {
    
    /**
     * 
     * @param loginName
     * @param password 未加密的密码
     * @return
     */
    public User checkUser(String loginName, String password);
    /**
     * 修改密码
     * @param userId
     * @param password 未加密的密码
     * @return
     */
    public boolean modifyPassword(long userId, String password);
    /**
     * 根据条件获取用户
     * @param offset
     * @param limit 为0时返回所有用户
     * @return 不会为null
     */
    public List<User> getUsers(int offset, int limit);
    /**
     * 获取用户数量
     * @return
     */
    public int getUserCount();
}
