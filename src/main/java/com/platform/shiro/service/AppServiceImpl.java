package com.platform.shiro.service;

import com.platform.shiro.dao.AppMapper;
import com.platform.shiro.entity.App;
import com.platform.utils.Page;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 
* @ClassName: AppServiceImpl 
* @Description: 应用
* @author yangyw(imalex@163.com)
* @date 2015年3月20日 下午2:03:56 
*
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
