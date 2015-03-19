<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
	<%
		String ctx = request.getContextPath();
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+ctx;
		request.setAttribute("ctx", ctx);
	%>
	<meta http-equiv="Content-Type" content="text/html;charset=UTF-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0"/> 
	<meta content="yes" name="apple-mobile-web-app-capable"/>
	<meta content="black" name="apple-mobile-web-app-status-bar-style"/>
	<meta content="telephone=no" name="format-detection"/>
	<meta content="no-cache" http-equiv="Cache-Control"/>
	<link rel="stylesheet" href="${ctx}/static/css/base.css?vision=1.1" type="text/css"/>
	<link rel="stylesheet" href="${ctx}/static/css/style.css" type="text/css"/>
	<link rel="stylesheet" href="${ctx}/static/css/pagetag.css" type="text/css"/>
	<script src="${ctx}/static/js/common/jquery-1.11.1.min.js" type="text/javascript"></script>
	<script src="${ctx}/static/js/common/jquery.validate.js" type="text/javascript"></script>
	<script src="${ctx}/static/js/common/fun_all.js" type="text/javascript"></script>	
	<script type="text/javascript">var ctx ="<%=ctx%>";</script>