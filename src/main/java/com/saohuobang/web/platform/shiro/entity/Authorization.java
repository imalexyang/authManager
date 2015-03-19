package com.saohuobang.web.platform.shiro.entity;

import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>User: yanqiang
 * <p>Date: 15-1-8
 * <p>Version: 1.0
 */
public class  Authorization implements Serializable {
    private Long id;
    private Long userId;
    private Long appId;
    private String roleIds;    
    private List<Long> roleIdsList;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getAppId() {
        return appId;
    }

    public void setAppId(Long appId) {
        this.appId = appId;
    }
    public String getRoleIds() {
        /*if(roleIds == null) {
            roleIds = new ArrayList<Long>();
        }*/
        return roleIds;
    }

    public void setRoleIds(String roleIds) {
        this.roleIds = roleIds;
    }


   /* public String getRoleIdsStr() {
        if(CollectionUtils.isEmpty(roleIds)) {
            return "";
        }
        StringBuilder s = new StringBuilder();
        for(Long roleId : roleIds) {
            s.append(roleId);
            s.append(",");
        }
        return s.toString();
    }*/

   /* public void setRoleIdsStr(String roleIdsStr) {
        if(StringUtils.isEmpty(roleIdsStr)) {
            return;
        }
        String[] roleIdStrs = roleIdsStr.split(",");
        for(String roleIdStr : roleIdStrs) {
            if(StringUtils.isEmpty(roleIdStr)) {
                continue;
            }
            getRoleIds().add(Long.valueOf(roleIdStr));
        }
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Authorization that = (Authorization) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Authorization{" +
                "id=" + id +
                ", userId=" + userId +
                ", appId=" + appId +
                ", roleIds=" + roleIds +
                '}';
    }

	public List<Long> getRoleIdsList() {
		String[] dbroleIds=roleIds.split(",");  
		List<Long> list=new ArrayList<Long>();
        for(String dbroleId:dbroleIds){
        	if(!dbroleId.equals("")){
        		list.add(Long.valueOf(dbroleId));
        	}        	
        }
		return list;
	}

	public void setRoleIdsList(List<Long> roleIdsList) {
		String[] dbroleIds=roleIds.split(",");  
		List<Long> list=new ArrayList<Long>();
        for(String dbroleId:dbroleIds){
        	if(!dbroleId.equals("")){
        		list.add(Long.valueOf(dbroleId));
        	}
        }
		this.roleIdsList = list;
	}  
}
