package com.wujie.weeklyreport.iterceptor;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

import com.wujie.weeklyreport.controller.ReturnBody;

public class LoginInfoInterceptor implements HandlerInterceptor {

    public void afterCompletion(HttpServletRequest request,
	    HttpServletResponse response, Object handler, Exception exception)
	    throws Exception {
	
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response,
	    Object handler, org.springframework.web.servlet.ModelAndView modelAndView)
	    throws Exception {
	
    }

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
	    Object handler) throws Exception {
	if("/login.action".equals(request.getServletPath())) {
	    return true;
	}
	HttpSession session = request.getSession();
	Object user = session.getAttribute("user");
	if(null != user) {
	    return true;
	}
	response.setCharacterEncoding("utf-8");
	PrintWriter writer = response.getWriter();
	writer.write(ReturnBody.NOT_LOGIN.toJson().toString());
	writer.flush();
	writer.close();
	return false;
    }


}
