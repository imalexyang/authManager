package com.platform.shiro.dao;

import java.util.List;
import java.util.Map;

import com.platform.shiro.entity.Authorization;
import com.platform.utils.Page;

public interface AuthorizationMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Authorization record);

    int insertSelective(Authorization record);

    Authorization selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Authorization record);

    int updateByPrimaryKey(Authorization record);
    
    public List<Authorization> selectAll();
    
    public List<Authorization> selectPage(Page<Authorization> p);

    public Authorization selectByAppUser(Map<String,Object> map);
    
}