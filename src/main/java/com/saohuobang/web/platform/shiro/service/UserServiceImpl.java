package com.saohuobang.web.platform.shiro.service;

import com.saohuobang.web.platform.shiro.dao.UserMapper;
import com.saohuobang.web.platform.shiro.entity.User;
import com.saohuobang.web.platform.utils.Page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * <p>User: yanqiang
 * <p>Date: 15-1-8
 * <p>Version: 1.0
 */
@Service

public class UserServiceImpl implements UserService {

   /* @Autowired
    private UserDao userDao;*/
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private PasswordHelper passwordHelper;
    @Autowired
    private RoleService roleService;

    /**
     * 创建用户
     * @param user
     */
    public User createUser(User user) {
        //加密密码
        passwordHelper.encryptPassword(user);
        userMapper.insert(user);
        return user;
    }

    @Override
    public User updateUser(User user) {
    	userMapper.updateByPrimaryKeySelective(user);
        return user;
    }

    @Override
    public void deleteUser(Long userId) {
    	userMapper.deleteByPrimaryKey(userId);
    }

    /**
     * 修改密码
     * @param userId
     * @param newPassword
     */
    public void changePassword(Long userId, String newPassword) {
    	
        User user =userMapper.selectByPrimaryKey(userId);
        user.setPassword(newPassword);
        passwordHelper.encryptPassword(user);
        userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public User findOne(Long userId) {
    	
        return userMapper.selectByPrimaryKey(userId);
    }

    @Override
    public List<User> findAll() {    	
        return userMapper.selectAll();
    }

    /**
     * 根据用户名查找用户
     * @param username
     * @return
     */
    public User findByUsername(String username) {
    	Map<String,Object> map=new HashMap<String,Object>();
    	map.put("userName", username);
    	User u = userMapper.selectByUsername(map);
        return u ;
    }

	@Override
	public List<User> findPage(Page<User> p) {
		// TODO Auto-generated method stub
		return userMapper.selectPage(p);
	}


}
