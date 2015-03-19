package com.saohuobang.web.platform.shiro.dao;

import java.util.List;
import java.util.Map;

import com.saohuobang.web.platform.shiro.entity.Organization;

public interface OrganizationMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Organization record);

    int insertSelective(Organization record);

    Organization selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Organization record);

    int updateByPrimaryKey(Organization record);
    
    List<Organization> selectAll();

    List<Organization> selectAllWithExclude(Map<String,Object> map);

    int moveStepOne(Map<String,Object> map);
    
    int moveStepTwo(Map<String,Object> map);
}