package com.platform.shiro.session.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.ValidatingSession;
import org.apache.shiro.session.mgt.eis.CachingSessionDAO;

import com.platform.shiro.service.RedisService;


public class RedisShiroSessionDao extends CachingSessionDAO {
	
	private String sessionprefix="ss-";
	
	private RedisService cached;
	
	@Override
	public void update(Session session) throws UnknownSessionException {
	   if(session instanceof ValidatingSession && !((ValidatingSession)session).isValid()) {
           return; //如果会话过期/停止 没必要再更新�?
       }
		try {
			cached.updateCached(session.getId().toString(),session);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Session session) {
		try {
			cached.deleteCached(session.getId().toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Session> getActiveSessions() {
		String keys=sessionprefix+"*";
		Set<Session> list=null;
		try {
		 list=	(Set<Session>) cached.getShiroSessionByKeys(keys);
		} catch (Exception e) {
		}
		return list;
	}

	@Override
	protected Serializable doCreate(Session session) {
		Serializable sessionId=session.getId();
		try {
			super.assignSessionId(session, sessionprefix+super.generateSessionId(session));
			update(session);
			sessionId=session.getId();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sessionId;
	}
	
	@Override
	protected Session doReadSession(Serializable sessionId) {
		Session session=null;
		try {
			session= (Session) cached.getCached(sessionId.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return session;
	}

	public String getSessionprefix() {
		return sessionprefix;
	}

	public void setSessionprefix(String sessionprefix) {
		this.sessionprefix = sessionprefix;
	}

	@Override
	protected void doUpdate(Session session) {
		if(session instanceof ValidatingSession && !((ValidatingSession)session).isValid()) {
	           return; //如果会话过期/停止 没必要再更新�?
	       }
		update(session);
	}

	@Override
	protected void doDelete(Session session) {
		delete(session);
	}
	
	public RedisService getCached() {
		return cached;
	}

	public void setCached(RedisService cached) {
		this.cached = cached;
	}
	
}
