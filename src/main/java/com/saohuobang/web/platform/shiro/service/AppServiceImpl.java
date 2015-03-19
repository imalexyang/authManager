package com.saohuobang.web.platform.shiro.service;

import com.saohuobang.web.platform.shiro.dao.AppMapper;
import com.saohuobang.web.platform.shiro.entity.App;
import com.saohuobang.web.platform.utils.Page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>User: yanqiang
 * <p>Date: 15-1-8
 * <p>Version: 1.0
 */
@Service

public class AppServiceImpl implements AppService {

   /* @Autowired
    private AppDao appDao;*/
    
    @Autowired
    private AppMapper appMapper;

    public App createApp(App app) {
        appMapper.insertSelective(app);
        return app;
    }

    public App updateApp(App app) {
    	appMapper.updateByPrimaryKeySelective(app);
        return app;
    }

    public void deleteApp(Long appId) {
        appMapper.deleteByPrimaryKey(appId);
    }

    @Override
    public App findOne(Long appId) {    	
        return appMapper.selectByPrimaryKey(appId);
        
    }

    @Override
    public List<App> findAll() {    	
        return appMapper.selectAll();
    }

    @Override
    public List<App> findPage(Page<App> p){
    	  return appMapper.selectPage(p);
    }
    
    @Override
    public Long findAppIdByAppKey(String appKey) {    	
        return appMapper.selectAppIdByAppKey(appKey);
    }
}
