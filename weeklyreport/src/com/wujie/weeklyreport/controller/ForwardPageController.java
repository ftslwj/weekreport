package com.wujie.weeklyreport.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 页面跳转控制器
 * @author wujie
 *
 */
@Controller
public class ForwardPageController {

    @RequestMapping("/usermanagepage")
    public String userManagePage() {
	return "usermanage";
    }
}
