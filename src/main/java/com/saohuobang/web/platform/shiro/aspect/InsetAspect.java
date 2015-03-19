package com.saohuobang.web.platform.shiro.aspect;

import java.util.Date;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import com.saohuobang.web.common.util.UUID;
import com.saohuobang.web.platform.shiro.entity.BaseEntity;

/**
 * author yanqiang
 */
@Aspect
public class InsetAspect {
	Logger logger = Logger.getLogger(InsetAspect.class);

	@Before("execution(* com.saohuobang..service..*.insert*(..))")
	public void add(JoinPoint jp) throws Exception {
		Object[] objects = jp.getArgs();
		if (objects[0] instanceof BaseEntity) {
			Date date = new Date();
			((BaseEntity) objects[0]).setFdid(UUID.getUUID());
			((BaseEntity) objects[0]).setCreatetime(date);
//			((BaseEntity) objects[0]).setCreatorid(UserUtil.getUserId());
			((BaseEntity) objects[0]).setUpdatetime(date);
//			((BaseEntity) objects[0]).setUpdatorid(UserUtil.getUserId());
		}
		logger.info("添加...");
	}

	@Before("execution(* com.saohuobang..service..*.update*(..))")
	public void update(JoinPoint jp) throws Exception {
		Object[] objects = jp.getArgs();
		if (objects[0] instanceof BaseEntity) {
			Date date = new Date();
			((BaseEntity) objects[0]).setUpdatetime(date);
//			((BaseEntity) objects[0]).setUpdatorid(UserUtil.getUserId());
		}
		logger.info("更新...update");
	}
}
