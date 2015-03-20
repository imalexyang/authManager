package com.platform.shiro.service;

import com.platform.shiro.entity.Role;
import com.platform.utils.Page;

import java.util.List;
import java.util.Set;

/**
 * 
* @ClassName: RoleService 
* @Description: 角色
* @author yangyw(imalex@163.com)
* @date 2015年3月20日 下午2:06:05 
*
 */
public interface RoleService {


    public Role createRole(Role role);
    public Role updateRole(Role role);
    public void deleteRole(Long roleId);

    public Role findOne(Long roleId);
    public List<Role> findAll();
    public List<Role> findPage(Page<Role> p);

    /**
     * 根据角色编号得到角色标识符列�?
     * @param roleIds
     * @return
     */
    Set<String> findRoles(Long... roleIds);

    /**
     * 根据角色编号得到权限字符串列�?
     * @param roleIds
     * @return
     */
    Set<String> findPermissions(Long[] roleIds);
}
