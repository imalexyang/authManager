<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ include file="../../jsp/common/resource.jsp"%>
<%@ include file="../../jsp/common/tags.jsp"%>
<title>修改密码</title>
	<link rel="stylesheet" href="${ctx}/static/JQuery zTree v3.5.15/css/zTreeStyle/zTreeStyle.css" />
	<script src="${ctx}/static/JQuery zTree v3.5.15/js/jquery.ztree.all-3.5.min.js"></script>
	<script src="${ctx}/static/js/user/list.js"></script>
	<style>
        ul.ztree {margin-top: 10px;border: 1px solid #617775;background: #f0f6e4;width:220px;height:200px;overflow-y:scroll;overflow-x:auto;}
    </style>
</head>
<body>   
	<div class="col_main lightshadow">
        <h2 class="page_headline"><span class="c_blue store_title">修改密码</span></h2>
        <div class="pb50">
          <!-- 表格开始 -->
			       <form method="post" id="cpform">
				       <div class="add_store">
				              <ol class="add_store_ol">
				                  <li class="add_store_li">
				                      <span class="add_store_span">新密码：</span>
				                      <div>
				                          <input id="newPassword" type="text" name="newPassword" placeholder="输入新密码" class="add_store_inp"/>
				                      </div>
				                  </li>
				                 </ol>
			              <a href="javascript:void(0)" name="submit" onclick="document.getElementById('cpform').submit();" class="btn btn_primary">${op}</a>
			        	</div>			       
				    </form>
             <!-- 表格结束-->
        </div>  
      </div>
</body>
</html>