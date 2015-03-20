package com.platform.shiro.dao;

import java.util.List;

import com.platform.shiro.entity.Role;
import com.platform.utils.Page;

/**
 * 
* @ClassName: RoleMapper 
* @Description: 角色
* @author yangyw(imalex@163.com)
* @date 2015年3月20日 下午1:57:45 
*
 */
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