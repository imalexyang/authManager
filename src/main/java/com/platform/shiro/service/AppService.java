package com.platform.shiro.service;

import com.platform.shiro.entity.App;
import com.platform.utils.Page;

import java.util.List;

/**
 * 
* @ClassName: AppService 
* @Description: 应用
* @author yangyw(imalex@163.com)
* @date 2015年3月20日 下午2:03:43 
*
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
