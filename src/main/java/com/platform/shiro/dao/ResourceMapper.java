package com.platform.shiro.dao;

import java.util.List;

import com.platform.shiro.entity.Resource;

/**
 * 
* @ClassName: ResourceMapper 
* @Description: 资源
* @author yangyw(imalex@163.com)
* @date 2015年3月20日 下午1:57:34 
*
 */
public interface ResourceMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Resource record);

    int insertSelective(Resource record);

    Resource selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Resource record);

    int updateByPrimaryKey(Resource record);
    
    List<Resource> selectAll();
}