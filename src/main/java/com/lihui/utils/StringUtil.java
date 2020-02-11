package com.lihui.utils;

public class StringUtil {

	/**
	 * 
	 * @Title: isNumber 
	 * @Description: 判断是否为数字
	 * @param string
	 * @return
	 * @return: Boolean
	 */
	public static Boolean isNumber(String string) {
		//正则表达式
		String zz="^([1-9][0-9]+)|((([0-9])|([1-9]\\d+))\\.\\d+)$";
		return string.matches(zz);
	}
	/**
	 * 
	 * @Title: isNull 
	 * @Description: 判断字符串是否为空
	 * @param string
	 * @return
	 * @return: Boolean
	 */
	public static Boolean isNull(String string) {
		if(null==string || string.equals("") ) {
			return true;
		}else {
			return false;
		}
	}
	/**
	 * 
	 * @Title: isNotNull 
	 * @Description: 判断字符串是否不为空
	 * @param string
	 * @return
	 * @return: Boolean
	 */
	public static Boolean isNotNull(String string) {
		if(null==string || string.equals("") ) {
			return false;
		}else {
			return true;
		}
	}
	/**
	 * 
	 * @Title: isEmail 
	 * @Description: 判断是否为邮箱
	 * @param string
	 * @return
	 * @return: Boolean
	 */
	public static Boolean isEmail(String string) {
		//正则表达式
		String zz="^\\w+@\\w+\\.(com|cn|net|com\\.cn)$";
		return string.matches(zz);
	}
	/**
	 * 
	 * @Title: isPhone 
	 * @Description: 判断是否为手机号
	 * @param string
	 * @return
	 * @return: Boolean
	 */
	public static Boolean isPhone(String string) {
		String zz="^1[3-9]\\d{9}$";
		return string.matches(zz);
	}
	
	public static void main(String[] args) {
		System.out.println("判断字符串是否为空："+isNull(""));
		System.out.println("判断字符串是否不为空："+isNotNull(""));
		System.out.println("判断是否为手机号："+isPhone("13709900000"));
		System.out.println("判断是否为邮箱："+isEmail("1370@qq.com"));
	}
}
