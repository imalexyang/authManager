<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ include file="../../jsp/common/resource.jsp"%>
<%@ include file="../../jsp/common/tags.jsp"%>
<title>编辑应用管理</title>
</head>
<body>   
	<div class="col_main lightshadow">
        <h2 class="page_headline"><span class="c_blue store_title">编辑应用管理</span></h2>
        <div class="pb50">
          <!-- 内容开始 -->
           <form:form method="post" commandName="app">
		        <form:hidden path="id"/>
		        <form:hidden path="available"/>
		
		        <div class="add_store">
			              <ol class="add_store_ol">
			                  <li class="add_store_li">
			                      <span class="add_store_span">应用名称：</span>
			                      <div> 
			                      		<input id="name" type="text" name="name" value="${app.name}" placeholder="输入应用名称" class="add_store_inp"/>
			                      </div>
			                  </li>
		           			  <li class="add_store_li">
			                      <span class="add_store_span">应用KEY：</span>
			                      <div> 
			                      		<input id="appKey" type="text" name="appKey" value="${app.appKey}" placeholder="输入应用KEY" class="add_store_inp"/>
			                      </div>
			                  </li>
			                  <li class="add_store_li">
			                      <span class="add_store_span">应用安全码：</span>
			                      <div> 
			                      		<input id="appSecret" type="text" name="appSecret" value="${app.appSecret}" placeholder="输入应用安全码" class="add_store_inp"/>
			                      </div>
			                  </li>    		
		       				 </ol>
			              <a href="javascript:void(0)" name="submit" onclick="document.getElementById('app').submit();" class="btn btn_primary">${op}</a>
			        </div>		
		    </form:form>
		  <!-- 内容结束 -->   
        </div>         
      </div>
</body>
</html>