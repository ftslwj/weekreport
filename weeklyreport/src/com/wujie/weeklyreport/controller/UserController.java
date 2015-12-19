package com.wujie.weeklyreport.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wujie.weeklyreport.po.User;
import com.wujie.weeklyreport.service.UserService;

/**
 * 用户相关控制器
 * @author wujie
 *
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;
    
    @RequestMapping("/getusers")
    @ResponseBody
    public UsersReturnBody getUsers(int page, int rows) {
	UsersReturnBody returnBody = new UsersReturnBody();
	returnBody.setTotal(userService.getUserCount());
	returnBody.setRows(userService.getUsers((page - 1) * rows, rows));
	return returnBody;
    }
    
    
    class UsersReturnBody {
	private int total;
	private List<User> rows;
	public int getTotal() {
	    return total;
	}
	public void setTotal(int total) {
	    this.total = total;
	}
	public List<User> getRows() {
	    return rows;
	}
	public void setRows(List<User> rows) {
	    this.rows = rows;
	}
    }
    
}
