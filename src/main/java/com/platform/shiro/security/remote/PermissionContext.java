package com.platform.shiro.security.remote;

import java.io.Serializable;
import java.util.Set;

public class PermissionContext
  implements Serializable
{
  private Set<String> roles;
  private Set<String> permissions;

  public Set<String> getRoles()
  {
    return this.roles;
  }

  public void setRoles(Set<String> roles) {
    this.roles = roles;
  }

  public Set<String> getPermissions() {
    return this.permissions;
  }

  public void setPermissions(Set<String> permissions) {
    this.permissions = permissions;
  }

  public String toString()
  {
    return "PermissionContext{, roles=" + this.roles + ", permissions=" + this.permissions + '}';
  }
}
