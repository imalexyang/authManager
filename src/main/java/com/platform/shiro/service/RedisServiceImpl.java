package com.platform.shiro.service;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Service;

import com.platform.commons.redis.core.BaseJedisTemplate;

/**
 * 
* @ClassName: RedisServiceImpl 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author yangyw(imalex@163.com)
* @date 2015年3月20日 下午2:05:32 
*
 */
@SuppressWarnings("rawtypes")
@Service("redisCached")
public class RedisServiceImpl extends BaseJedisTemplate implements RedisService {

	@Override
	public String deleteCached(final String sessionId) throws Exception {
		String[] sessionIds = new String[]{sessionId};
		super.delByKeys(sessionIds);
		return sessionId;
	}

	@SuppressWarnings("unchecked")
	@Override
	public String updateCached(final String key,final Object session) throws Exception {
		super.saveValue(key, session,30,TimeUnit.MINUTES);
		return key;
	}

	@Override
	public Object getCached(final String sessionId) throws Exception {
		return super.getValueByKey(sessionId);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Set<Object> getShiroSessionByKeys(String keys) throws Exception {
		Set<byte[]> keys_resault = super.getKeysLike(keys);
		if (keys_resault == null || keys_resault.size() < 1) {
			return null;
		}
		Set <Object>set = new HashSet();
		for (byte[] key : keys_resault) {
			set.add(super.getValueByKey(new String(key)));
		}
		return set;
	}
}
