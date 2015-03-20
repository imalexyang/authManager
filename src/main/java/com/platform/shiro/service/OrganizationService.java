package com.platform.shiro.service;

import com.platform.shiro.entity.Organization;

import java.util.List;

/**
 * 
* @ClassName: OrganizationService 
* @Description: 组织
* @author yangyw(imalex@163.com)
* @date 2015年3月20日 下午2:04:31 
*
 */
public interface OrganizationService {


    public Organization createOrganization(Organization organization);
    public Organization updateOrganization(Organization organization);
    public void deleteOrganization(Long organizationId);

    Organization findOne(Long organizationId);
    List<Organization> findAll();

    Object findAllWithExclude(Organization excludeOraganization);

    void move(Organization source, Organization target);
}
