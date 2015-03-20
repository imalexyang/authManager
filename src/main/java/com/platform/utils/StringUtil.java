package com.platform.utils;

/**
 * 
* @ClassName: StringUtil 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author yangyw(imalex@163.com)
* @date 2015年3月20日 下午2:13:46 
*
 */
public class StringUtil {
		/**
		 * 判断字符串指向是否为空或trim后的长度是否0
		 * @param str 被判断字符串
		 * @return 为空或�?�trim后长度为0时返回true
		 */
		public static boolean isEmpty(String str) {
			return str == null || str.trim().length() == 0;
		}

		/**
		 * 与isEmpty逻辑相反
		 * @param str 被判断字符串
		 * @return 为空或�?�trim后长度为0时返回false
		 */
		public static boolean isNotEmpty(String str) {
			return !isEmpty(str);
		}

}
