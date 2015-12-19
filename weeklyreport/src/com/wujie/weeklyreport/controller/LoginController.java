package com.wujie.weeklyreport.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wujie.weeklyreport.po.User;
import com.wujie.weeklyreport.service.UserService;
import com.wujie.weeklyreport.utils.MD5Util;
import com.wujie.weeklyreport.utils.StringUtil;

@Controller
public class LoginController {
    
    @Autowired
    private UserService userService;
    
    @RequestMapping("/login")
    @ResponseBody 
    public ReturnBody login(HttpSession session, String loginName, String password) throws Exception {
	User user = userService.checkUser(loginName, password);
	if(null == user) {
	    return new ReturnBody(101, "账号或密码错误");
	}
	session.setAttribute("user", user);
	return ReturnBody.SUCCESS;
    }
    
    @RequestMapping("/logout")
    @ResponseBody
    public ReturnBody logout(HttpSession session) throws Exception {
	Object user = session.getAttribute("user");
	if(null != user) {
	    session.removeAttribute("user");
	}
	return ReturnBody.SUCCESS;
    }
    
    @RequestMapping("/modifypwd")
    @ResponseBody
    public ReturnBody modifypassword(HttpSession session, String oldpwd, String newpwd) throws Exception {
	if(StringUtil.isEmpty(oldpwd)) {
	    return new ReturnBody(100, "请输入原始密码");
	}
	if(StringUtil.isEmpty(newpwd)) {
	    return new ReturnBody(100, "请输入新密码");
	}
	User user = (User) session.getAttribute("user");
	if(!MD5Util.md5(oldpwd).equals(user.getPassword())) {
	    return new ReturnBody(100, "原始密码错误");
	}
	if(userService.modifyPassword(user.getId(), newpwd)) {
	    return ReturnBody.SUCCESS;
	}
	 return new ReturnBody(100, "修改失败");
    }

}
