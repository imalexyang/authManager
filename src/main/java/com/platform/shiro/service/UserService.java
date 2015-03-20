package com.platform.shiro.service;

import com.platform.shiro.entity.User;
import com.platform.utils.Page;

import java.util.List;
import java.util.Set;

/**
 * 
* @ClassName: UserService 
* @Description: 用户
* @author yangyw(imalex@163.com)
* @date 2015年3月20日 下午2:06:30 
*
 */
public interface UserService {

    /**
     * 创建用户
     * @param user
     */
    public User createUser(User user);

    public User updateUser(User user);

    public void deleteUser(Long userId);

    /**
     * 修改密码
     * @param userId
     * @param newPassword
     */
    public void changePassword(Long userId, String newPassword);


    User findOne(Long userId);

    List<User> findAll();
    List<User> findPage(Page<User> p);

    /**
     * 根据用户名查找用�?
     * @param username
     * @return
     */
    public User findByUsername(String username);


}
