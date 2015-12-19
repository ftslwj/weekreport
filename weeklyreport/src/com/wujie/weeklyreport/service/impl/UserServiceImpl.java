package com.wujie.weeklyreport.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wujie.weeklyreport.mapper.UserMapper;
import com.wujie.weeklyreport.po.User;
import com.wujie.weeklyreport.service.UserService;
import com.wujie.weeklyreport.utils.MD5Util;
import com.wujie.weeklyreport.utils.StringUtil;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;
    
    public User checkUser(String loginName, String password) {
	if(StringUtil.isEmpty(loginName) || StringUtil.isEmpty(password)) {
	    return null;
	}
	return userMapper.getUserByLoginNameAndPassword(loginName, MD5Util.md5(password));
    }
    
    public boolean modifyPassword(long userId, String password) {
	if(StringUtil.isEmpty(password)) {
	    return false;
	}
        return userMapper.modifyPassword(userId, MD5Util.md5(password)) > 0;
    }

    public List<User> getUsers(int offset, int limit) {
	int count = getUserCount();
	if(count <= 0) {
	    return new ArrayList<User>(0);
	}
	if(limit <= 0) {
	    //返回所有用户
	    return userMapper.getUsers(0, 0);
	}
	if(offset < 0) {
	    offset = 0;
	}
	if(offset >= count) {
	    return new ArrayList<User>(0);
	}
	if(offset + limit > count) {
	    limit = count - offset;
	}
	//根据offset limit 返回用户
	return userMapper.getUsers(offset, limit);
    }
    
    public int getUserCount() {
        return userMapper.getUserCount();
    }

}
