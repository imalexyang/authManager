package com.saohuobang.web.platform.utils;

public class StringUtil {
		/**
		 * 判断字符串指向是否为空或trim后的长度是否0
		 * @param str 被判断字符串
		 * @return 为空或者trim后长度为0时返回true
		 */
		public static boolean isEmpty(String str) {
			return str == null || str.trim().length() == 0;
		}

		/**
		 * 与isEmpty逻辑相反
		 * @param str 被判断字符串
		 * @return 为空或者trim后长度为0时返回false
		 */
		public static boolean isNotEmpty(String str) {
			return !isEmpty(str);
		}

}
