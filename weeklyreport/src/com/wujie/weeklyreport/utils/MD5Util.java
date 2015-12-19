package com.wujie.weeklyreport.utils;

import java.security.MessageDigest;

public class MD5Util {
    /**
     * 把字节数组转成16进位制数
     * @param bytes
     * @return
     */
    private static String bytesToHex(byte[] bytes) {
	StringBuffer md5str = new StringBuffer();
	// 把数组每一字节换成16进制连成md5字符串
	int digital;
	for (int i = 0; i < bytes.length; i++) {
	    digital = bytes[i];
	    if (digital < 0) {
		digital += 256;
	    }
	    if (digital < 16) {
		md5str.append("0");
	    }
	    md5str.append(Integer.toHexString(digital));
	}
	return md5str.toString();
    }

    /**
     * 把字节数组转换成md5
     * @param input
     * @return
     */
    public static String md5(String s) {
	if(StringUtil.isEmpty(s)) {
	    return null;
	}
	String md5str = null;
	try {
	    // 创建一个提供信息摘要算法的对象，初始化为md5算法对象
	    MessageDigest md = MessageDigest.getInstance("MD5");
	    // 计算后获得字节数组
	    byte[] buff = md.digest(s.getBytes());
	    // 把数组每一字节换成16进制连成md5字符串
	    md5str = bytesToHex(buff);
	} catch (Exception e) {
	    e.printStackTrace();
	}
	return md5str.toUpperCase();
    }
}
