package com.platform.shiro.dao;

import java.util.List;
import java.util.Map;

import com.platform.shiro.entity.Organization;

/**
 * 
* @ClassName: OrganizationMapper 
* @Description: 组织
* @author yangyw(imalex@163.com)
* @date 2015年3月20日 下午1:57:16 
*
 */
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