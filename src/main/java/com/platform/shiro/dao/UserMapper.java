package com.platform.shiro.dao;

import java.util.List;
import java.util.Map;

import com.platform.shiro.entity.User;
import com.platform.utils.Page;

public interface UserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    List<User> selectAll();
    
    List<User> selectPage(Page<User> p);

    User selectByUsername(Map<String,Object> map);
}