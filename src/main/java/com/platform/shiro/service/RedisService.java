package com.platform.shiro.service;

import java.util.Set;

/**
 * 
* @ClassName: RedisService 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author yangyw(imalex@163.com)
* @date 2015年3月20日 下午2:05:18 
*
 */
public interface RedisService {
	/**
	 * 删除 缓存
	 * @param key
	 * @return
	 * @throws Exception
	 */
	String deleteCached(String key)throws Exception;
	/**
	 * 更新 缓存
	 * @param key
	 * @param value
	 * @return
	 * @throws Exception
	 */
	Object updateCached(String key,Object value)throws Exception;
	/**
	 * 获取缓存
	 * @param key
	 * @return
	 * @throws Exception
	 */
	Object getCached(String key)throws Exception;
	
	Set getShiroSessionByKeys(String keys) throws Exception;
	
	
}
