package com.wujie.weeklyreport.controller;

import net.sf.json.JSONObject;

public class ReturnBody {
    /**
     * 返回成功的消息
     */
    public static ReturnBody SUCCESS = new ReturnBody(0, "成功");
    /**
     * 未登录
     */
    public static ReturnBody NOT_LOGIN = new ReturnBody(999, "未登录");
    
    private Integer retCode;
    private String message;
    
    public ReturnBody() {
    }
    public ReturnBody(Integer retCode, String message) {
	this.retCode = retCode;
	this.message = message;
    }
    public Integer getRetCode() {
        return retCode;
    }
    public void setRetCode(Integer retCode) {
        this.retCode = retCode;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    
    public JSONObject toJson() {
	JSONObject jo = new JSONObject();
	jo.put("retCode", retCode);
	jo.put("message", message);
	return jo;
    }
    
    

}
