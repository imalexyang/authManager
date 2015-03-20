package com.platform.shiro.aspect;

import java.util.Date;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import com.platform.utils.UUID;
import com.platform.shiro.entity.BaseEntity;

/**
 * 
* @ClassName: InsetAspect 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author yangyw(imalex@163.com)
* @date 2015年3月20日 下午1:53:41 
*
 */
@Aspect
public class InsetAspect {
	Logger logger = Logger.getLogger(InsetAspect.class);

	@Before("execution(* com..service..*.insert*(..))")
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

	@Before("execution(* com..service..*.update*(..))")
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
