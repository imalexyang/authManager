package com.platform.shiro.service;

import com.platform.shiro.entity.Role;
import com.platform.utils.Page;

import java.util.List;
import java.util.Set;

/**
 * <p>User: yanqiang
 * <p>Date: 15-1-8
 * <p>Version: 1.0
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
