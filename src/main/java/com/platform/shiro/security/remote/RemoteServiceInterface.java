package com.platform.shiro.security.remote;

import java.io.Serializable;
import org.apache.shiro.session.Session;

public abstract interface RemoteServiceInterface
{
  public abstract Session getSession(String paramString, Serializable paramSerializable);

  public abstract Serializable createSession(Session paramSession);

  public abstract void updateSession(String paramString, Session paramSession);

  public abstract void deleteSession(String paramString, Session paramSession);

  public abstract PermissionContext getPermissions(String paramString1, String paramString2);
}
