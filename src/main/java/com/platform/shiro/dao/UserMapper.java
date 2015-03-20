package com.platform.shiro.dao;

import java.util.List;
import java.util.Map;

import com.platform.shiro.entity.User;
import com.platform.utils.Page;

/**
 * 
* @ClassName: UserMapper 
* @Description: 用户 
* @author yangyw(imalex@163.com)
* @date 2015年3月20日 下午1:57:57 
*
 */
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