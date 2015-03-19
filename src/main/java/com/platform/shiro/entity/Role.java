package com.platform.shiro.entity;

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
public class Role implements Serializable {
    private Long id; //编号
    private String role; //角色标识 程序中判断使�?,�?"admin"
    private String description; //角色描述,UI界面显示使用
//    private List<Long> resourceIds; //拥有的资�?
    private List<Long> resourceIdsList;
    private String resourceIds; //拥有的资�?
    private Boolean available = Boolean.FALSE; //是否可用,如果不可用将不会添加给用�?

    public Role() {
    }

    public Role(String role, String description, Boolean available) {
        this.role = role;
        this.description = description;
        this.available = available;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getResourceIds() {
//        if(resourceIds == null) {
//            resourceIds = new ArrayList<Long>();
//        }
        return resourceIds;
    }

    public void setResourceIds(String resourceIds) {
        this.resourceIds = resourceIds;
    }

//    public String getResourceIdsStr() {
//        if(CollectionUtils.isEmpty(resourceIds)) {
//            return "";
//        }
//        StringBuilder s = new StringBuilder();
//        for(Long resourceId : resourceIds) {
//            s.append(resourceId);
//            s.append(",");
//        }
//        return s.toString();
//    }

//    public void setResourceIdsStr(String resourceIdsStr) {
//        if(StringUtils.isEmpty(resourceIdsStr)) {
//            return;
//        }
//        String[] resourceIdStrs = resourceIdsStr.split(",");
//        for(String resourceIdStr : resourceIdStrs) {
//            if(StringUtils.isEmpty(resourceIdStr)) {
//                continue;
//            }
//            getResourceIds().add(Long.valueOf(resourceIdStr));
//        }
//    }

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Role role = (Role) o;

        if (id != null ? !id.equals(role.id) : role.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", role='" + role + '\'' +
                ", description='" + description + '\'' +
                ", resourceIds=" + resourceIds +
                ", available=" + available +
                '}';
    }

	public List<Long> getResourceIdsList() {
		List<Long> list=new ArrayList<Long>();
		if(resourceIds!=null){
			String[] dbroleIds=resourceIds.split(",");   
	        for(String dbroleId:dbroleIds){
	        	if(!dbroleId.equals("")){
	        		list.add(Long.valueOf(dbroleId));
	        	}
	        }
        }
		return list;
	}

	public void setResourceIdsList(List<Long> resourceIdsList) {
		String[] dbroleIds=resourceIds.split(",");  
		List<Long> list=new ArrayList<Long>();
        for(String dbroleId:dbroleIds){
        	if(!dbroleId.equals("")){
        		list.add(Long.valueOf(dbroleId));
        	}
        }
		this.resourceIdsList = list;
	}
}
