package com.platform.shiro.web.shiro.filter;

import com.platform.shiro.Constants;
import com.platform.shiro.service.UserService;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.web.filter.PathMatchingFilter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * 
* @ClassName: SysUserFilter 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author yangyw(imalex@163.com)
* @date 2015年3月20日 下午2:10:23 
*
 */
public class SysUserFilter extends PathMatchingFilter {

    @Autowired
    private UserService userService;

    @Override
    protected boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {

        String username = (String)SecurityUtils.getSubject().getPrincipal();
        request.setAttribute(Constants.CURRENT_USER, userService.findByUsername(username));
        return true;
    }
}
