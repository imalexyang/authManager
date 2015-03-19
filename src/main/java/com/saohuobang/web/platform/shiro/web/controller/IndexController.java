package com.saohuobang.web.platform.shiro.web.controller;

import com.saohuobang.web.platform.shiro.Constants;
import com.saohuobang.web.platform.shiro.entity.Organization;
import com.saohuobang.web.platform.shiro.entity.Resource;
import com.saohuobang.web.platform.shiro.service.AuthorizationService;
import com.saohuobang.web.platform.shiro.service.OrganizationService;
import com.saohuobang.web.platform.shiro.service.ResourceService;
import com.saohuobang.web.platform.shiro.service.UserService;
import com.saohuobang.web.platform.shiro.web.bind.annotation.CurrentUser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * <p>User: yanqiang
 * <p>Date: 15-1-8
 * <p>Version: 1.0
 */
@Controller
public class IndexController {

    @Autowired
    private ResourceService resourceService;
    @Autowired
    private AuthorizationService authorizationService;
    @Autowired
    private UserService userService;
    @Autowired
    private OrganizationService organizationService;

    @RequestMapping("/")
    public String index(@CurrentUser com.saohuobang.web.platform.shiro.entity.User loginUser, Model model) {
        Set<String> permissions = authorizationService.findPermissions(Constants.SERVER_APP_KEY, loginUser.getUsername());
        List<Resource> menus = resourceService.findMenus(permissions);
        model.addAttribute("menus", menus);        
   
        Organization org=organizationService.findOne(loginUser.getOrganizationId());
        //判断商户号非空，直接返回主界面        
        while(org.getStoreId()!=null&&!org.getStoreId().equals("")){        	
        	return "index";        	
        };
        //商户号为空，ID=1为集团账号初始化
        while(org.getId()==1){
        	model.addAttribute("url", "http://localhost/storeManager/store/configOne");
        	return "common/forward";  
        }     
        //商户号为空，门店初始化
        model.addAttribute("url", "http://localhost/storeManager/store/configStoreOne");
    	return "common/forward";
    }

    @RequestMapping("/menus")
    public String menus(@CurrentUser com.saohuobang.web.platform.shiro.entity.User loginUser, Model model,@RequestParam(value="pid",required=true) Long pid) {
            
        List<Resource> resourceList=new ArrayList<Resource>();
    	for(Resource resource:resourceService.findAll()){
    		if(resource.getParentId()==pid){
    			resourceList.add(resource);
    		}
    	}        
        model.addAttribute("menus", resourceList);
        return "common/menus";
    }
    
    @RequestMapping("/iframeAutoHeight")
    public String iframeAutoHeight(Model model) {
        return "common/autoFrameHeight";
    }
    
    @RequestMapping("/welcome")
    public String welcome() {
        return "welcome";
    }


}
