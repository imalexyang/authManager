package com.platform.shiro.dao;

import java.util.List;

import com.platform.shiro.entity.Role;
import com.platform.utils.Page;

public interface RoleMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Role record);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
    
    List<Role> selectAll();
    
    List<Role> selectPage(Page<Role> p);
}