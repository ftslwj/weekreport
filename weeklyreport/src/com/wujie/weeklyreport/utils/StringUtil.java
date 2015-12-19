package com.wujie.weeklyreport.utils;

public class StringUtil {

    /**
     * 判断字符串是否为空
     * @param s
     * @return
     */
    public static boolean isEmpty(String s) {
	return null == s || s.trim().isEmpty();
    }
}
