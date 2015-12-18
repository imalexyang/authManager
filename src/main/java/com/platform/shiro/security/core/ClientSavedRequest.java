package com.platform.shiro.security.core;

import javax.servlet.http.HttpServletRequest;
import org.apache.shiro.web.util.SavedRequest;

public class ClientSavedRequest extends SavedRequest
{
  private String scheme;
  private String domain;
  private int port;
  private String contextPath;
  private String backUrl;

  public ClientSavedRequest(HttpServletRequest request, String backUrl)
  {
    super(request);
    this.scheme = request.getScheme();
    this.domain = request.getServerName();
    this.port = request.getServerPort();
    this.backUrl = backUrl;
    this.contextPath = request.getContextPath();
  }

  public String getScheme() {
    return this.scheme;
  }

  public String getDomain() {
    return this.domain;
  }

  public int getPort() {
    return this.port;
  }

  public String getContextPath() {
    return this.contextPath;
  }

  public String getBackUrl() {
    return this.backUrl;
  }

  public String getRequestUrl() {
    String requestURI = getRequestURI();
    if (this.backUrl != null) {
      if ((this.backUrl.toLowerCase().startsWith("http://")) || (this.backUrl.toLowerCase().startsWith("https://")))
        return this.backUrl;
      if (!this.backUrl.startsWith(this.contextPath))
        requestURI = this.contextPath + this.backUrl;
      else {
        requestURI = this.backUrl;
      }
    }

    StringBuilder requestUrl = new StringBuilder(this.scheme);
    requestUrl.append("://");
    requestUrl.append(this.domain);

    if (("http".equalsIgnoreCase(this.scheme)) && (this.port != 80))
      requestUrl.append(":").append(String.valueOf(this.port));
    else if (("https".equalsIgnoreCase(this.scheme)) && (this.port != 443)) {
      requestUrl.append(":").append(String.valueOf(this.port));
    }

    requestUrl.append(requestURI);

    if ((this.backUrl == null) && (getQueryString() != null)) {
      requestUrl.append("?").append(getQueryString());
    }
    return requestUrl.toString();
  }
}