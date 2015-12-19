package com.wujie.weeklyreport.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wujie.weeklyreport.po.User;

public interface UserMapper {

    public User getUserByLoginNameAndPassword(@Param("loginname") String loginName, @Param("password") String password);
    
    public int modifyPassword(@Param("id") Long userId, @Param("password") String password);
    
    public List<User> getUsers(@Param("offset") Integer offset, @Param("limit") Integer limit);
    
    public int getUserCount();
}
