package com.platform.shiro.service;

import com.platform.shiro.entity.Organization;

import java.util.List;

/**
 * <p>User: yanqiang
 * <p>Date: 15-1-8
 * <p>Version: 1.0
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
