package com.saohuobang.web.platform.shiro.service;

import com.saohuobang.web.platform.shiro.entity.App;
import com.saohuobang.web.platform.utils.Page;

import java.util.List;

/**
 * <p>User: yanqiang
 * <p>Date: 15-1-8
 * <p>Version: 1.0
 */
public interface AppService {


    public App createApp(App app);
    public App updateApp(App app);
    public void deleteApp(Long appId);

    public App findOne(Long appId);
    public List<App> findAll();

    public List<App> findPage(Page<App> p);
    
    /**
     * 根据appKey查找AppId
     * @param appKey
     * @return
     */
    public Long findAppIdByAppKey(String appKey);
}
