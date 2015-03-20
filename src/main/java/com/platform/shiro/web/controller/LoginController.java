package com.platform.shiro.web.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * 
* @ClassName: LoginController 
* @Description: 登录
* @author yangyw(imalex@163.com)
* @date 2015年3月20日 下午2:08:48 
*
 */
@Controller
public class LoginController {

    @RequestMapping(value = "/mall/login")
    public String showMallLoginForm(HttpServletRequest req, Model model){
    	return doLogin(req,model ,"mall/login");
    }
    
    @RequestMapping(value = "/medical/login")
    public String showMedicalLoginForm(HttpServletRequest req, Model model){
    	return doLogin(req,model,"medical/login");
    }
    
    @RequestMapping(value = "/login")
    public String showLoginForm(HttpServletRequest req, Model model){
    	return doLogin(req, model,"login");
    }
    
    @RequestMapping(value = "/mall/logout")
    public String mallLogout(HttpServletRequest req, Model model){
    	doLogout();
    	return "mall/login";
    }
    @RequestMapping(value = "/medical/logout")
    public String medicalLogout(HttpServletRequest req, Model model){
    	 doLogout();
    	 return "medical/login";
    }
    		
    private String doLogin(HttpServletRequest req, Model model,String pageName) {
        String exceptionClassName = (String)req.getAttribute("shiroLoginFailure");
        String error = null;
        if(UnknownAccountException.class.getName().equals(exceptionClassName)) {
            error = "用户名/密码错误";
        } else if(IncorrectCredentialsException.class.getName().equals(exceptionClassName)) {
            error = "用户名/密码错误";
        } else if(exceptionClassName != null) {
            error = "其他错误：" + exceptionClassName;
        }
        model.addAttribute("error", error);
        return pageName;
    }
    
	private void doLogout(){
        Subject subject = SecurityUtils.getSubject();
        if (subject != null) {           
            subject.logout();
        }
    }


}
