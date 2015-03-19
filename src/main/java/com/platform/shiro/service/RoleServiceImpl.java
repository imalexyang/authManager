package com.platform.shiro.service;

import com.platform.shiro.dao.RoleMapper;
import com.platform.shiro.entity.Role;
import com.platform.utils.Page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <p>User: yanqiang
 * <p>Date: 15-1-8
 * <p>Version: 1.0
 */
@Service

public class RoleServiceImpl implements RoleService {

   /* @Autowired
    private RoleDao roleDao;*/
    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private ResourceService resourceService;

    public Role createRole(Role role) {
    	roleMapper.insertSelective(role);
        return role;
    }

    public Role updateRole(Role role) {
    	roleMapper.updateByPrimaryKeySelective(role);
        return role;
    }

    public void deleteRole(Long roleId) {
    	roleMapper.deleteByPrimaryKey(roleId);
    }

    @Override
    public Role findOne(Long roleId) {
    	return roleMapper.selectByPrimaryKey(roleId);
    }

    @Override
    public List<Role> findAll() {
    	return roleMapper.selectAll();
    }

    @Override
    public Set<String> findRoles(Long... roleIds) {
        Set<String> roles = new HashSet<String>();
        for(Long roleId : roleIds) {
            Role role = findOne(roleId);
            if(role != null) {
                roles.add(role.getRole());
            }
        }
        return roles;
    }

    @Override
    public Set<String> findPermissions(Long[] roleIds) {
        Set<Long> resourceIds = new HashSet<Long>();
        for(Long roleId : roleIds) {
            Role role = findOne(roleId);
            if(role != null) {
            	
            	//
            	 String[] resourceIdStrs = role.getResourceIds().split(",");
               for(String resourceIdStr : resourceIdStrs) {
                  if(resourceIdStr==null) {
                      continue;
                   }
                  resourceIds.add(Long.valueOf(resourceIdStr));
               }
            	//
            	
                //resourceIds.addAll(role.getResourceIds());
            }
        }
        return resourceService.findPermissions(resourceIds);
    }

	@Override
	public List<Role> findPage(Page<Role> p) {
		// TODO Auto-generated method stub
		return roleMapper.selectPage(p);
	}
}
