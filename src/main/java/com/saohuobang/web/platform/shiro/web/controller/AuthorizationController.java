package com.saohuobang.web.platform.shiro.web.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.saohuobang.web.platform.shiro.entity.Authorization;
import com.saohuobang.web.platform.shiro.service.AppService;
import com.saohuobang.web.platform.shiro.service.AuthorizationService;
import com.saohuobang.web.platform.shiro.service.RoleService;
import com.saohuobang.web.platform.shiro.service.UserService;
import com.saohuobang.web.platform.utils.Page;
import com.saohuobang.web.platform.utils.PageUtil;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * <p>User: yanqiang
 * <p>Date: 15-1-8
 * <p>Version: 1.0
 */
@Controller
@RequestMapping("/authorization")
public class AuthorizationController {

    @Autowired
    private AuthorizationService authorizationService;
    @Autowired
    private UserService userService;
    @Autowired
    private AppService appService;
    @Autowired
    private RoleService roleService;

    @RequiresPermissions("authorization:view")
    @RequestMapping()
    public String list(Model model,HttpServletRequest request,Map<String, Object> map) {
    	@SuppressWarnings("unchecked")
		Page<Authorization> p = PageUtil.buidPagebean(request, map);
		List<Authorization> authorizationList= authorizationService.findPage(p);	    	
        model.addAttribute("authorizationList", authorizationList);
        PageUtil.buildGrid(p);   
        return "authorization/list";
    }

    @RequiresPermissions("authorization:create")
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String showCreateForm(Model model) {
        setCommonData(model);
        Authorization authorization = new Authorization();
        model.addAttribute("authorization", authorization);
        model.addAttribute("op", "新增");
        return "authorization/edit";
    }

    @RequiresPermissions("authorization:create")
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(Authorization authorization, RedirectAttributes redirectAttributes) {
        authorizationService.createAuthorization(authorization);
        redirectAttributes.addFlashAttribute("msg", "新增成功");
        return "redirect:/authorization";
    }

    @RequiresPermissions("authorization:update")
    @RequestMapping(value = "/{id}/update", method = RequestMethod.GET)
    public String showUpdateForm(@PathVariable("id") Long id, Model model) {
        setCommonData(model);
        model.addAttribute("authorization", authorizationService.findOne(id));
        model.addAttribute("op", "修改");
        return "authorization/edit";
    }

    @RequiresPermissions("authorization:update")
    @RequestMapping(value = "/{id}/update", method = RequestMethod.POST)
    public String update(Authorization authorization, RedirectAttributes redirectAttributes) {
        authorizationService.updateAuthorization(authorization);
        redirectAttributes.addFlashAttribute("msg", "修改成功");
        return "redirect:/authorization";
    }

    @RequiresPermissions("authorization:delete")
    @RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
    public String showDeleteForm(@PathVariable("id") Long id, Model model) {
        setCommonData(model);
        model.addAttribute("authorization", authorizationService.findOne(id));
        model.addAttribute("op", "删除");
        return "authorization/edit";
    }

    @RequiresPermissions("authorization:delete")
    @RequestMapping(value = "/{id}/delete", method = RequestMethod.POST)
    public String delete(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        authorizationService.deleteAuthorization(id);
        redirectAttributes.addFlashAttribute("msg", "删除成功");
        return "redirect:/authorization";
    }

    private void setCommonData(Model model) {
        model.addAttribute("userList", userService.findAll());
        model.addAttribute("roleList", roleService.findAll());
        model.addAttribute("appList", appService.findAll());
    }


}
