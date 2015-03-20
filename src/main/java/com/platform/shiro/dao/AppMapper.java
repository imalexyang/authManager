package com.platform.shiro.dao;

import java.util.List;

import com.platform.shiro.entity.App;
import com.platform.utils.Page;

/**
 * 
* @ClassName: AppMapper 
* @Description: 应用
* @author yangyw(imalex@163.com)
* @date 2015年3月20日 下午1:56:00 
*
 */
public interface AppMapper {
    int deleteByPrimaryKey(Long id);

    int insert(App record);

    int insertSelective(App record);

    App selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(App record);

    int updateByPrimaryKey(App record);
    
    List<App> selectAll();
    
    List<App> selectPage(Page<App> p);
    
    Long selectAppIdByAppKey(String appKey);
}