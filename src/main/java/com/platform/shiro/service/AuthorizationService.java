package com.platform.shiro.service;

import com.platform.shiro.entity.Authorization;
import com.platform.utils.Page;

import java.util.List;
import java.util.Set;

/**
 * 
* @ClassName: AuthorizationService 
* @Description: 权限
* @author yangyw(imalex@163.com)
* @date 2015年3月20日 下午2:04:08 
*
 */
public interface AuthorizationService {


    public Authorization createAuthorization(Authorization authorization);
    public Authorization updateAuthorization(Authorization authorization);
    public void deleteAuthorization(Long authorizationId);

    public Authorization findOne(Long authorizationId);
    public List<Authorization> findAll();
    public List<Authorization> findPage(Page<Authorization> p);

    /**
     * 根据AppKey和用户名查找其角�?
     * @param username
     * @return
     */
    public Set<String> findRoles(String appKey, String username);

    /**
     * 根据AppKey和用户名查找权限字符�?
     * @param username
     * @return
     */
    public Set<String> findPermissions(String appKey, String username);


}
