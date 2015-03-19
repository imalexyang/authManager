<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ include file="../../jsp/common/resource.jsp"%>
<%@ include file="../../jsp/common/tags.jsp"%>
<title>编辑菜单</title>
</head>
<body>   
	<div class="col_main lightshadow">
        <h2 class="page_headline"><span class="c_blue store_title">编辑菜单</span></h2>
        <div class="pb50">
          <!-- 表格开始 -->
			     <form:form method="post" commandName="resource">
			        <form:hidden path="id"/>
			        <form:hidden path="available"/>
			        <form:hidden path="parentId"/>
			        <form:hidden path="parentIds"/>
			        
					<div class="add_store">
					              <ol class="add_store_ol">
						              <c:if test="${not empty parent}">
						                  <li class="add_store_li">
						                      <span class="add_store_span">父节点名称：</span>
						                      <div>
						                            ${parent.name}
						                      </div>
						                  </li>
					                  </c:if>
					                  <li class="add_store_li">
					                      <span class="add_store_span"><c:if test="${not empty parent}">子</c:if>名称：</span>
					                      <div>
					                          <input id="name" type="text" name="name" value="${resource.name}" placeholder="输入名称" class="add_store_inp"/>
					                      </div>
					                  </li>
					                  <li class="add_store_li">
					                      <span class="add_store_span">类型：</span>
					                      <div>
					                         	<select id="type" name="type">
													<option <c:if test="${resource.type!='button'}">selected="selected"</c:if> value="menu">菜单</option>
													<option <c:if test="${resource.type=='button'}">selected="selected"</c:if> value="button">按钮</option>
												</select>						
					                      </div>
					                  </li>
					                  <li class="add_store_li">
					                      <span class="add_store_span">URL路径：</span>
					                      <div>
					                          <input id="url" type="text" name="url" value="${resource.url}" placeholder="输入URL路径" class="add_store_inp"/>
					                      </div>
					                  </li>
					                  <li class="add_store_li">
					                      <span class="add_store_span">权限字符串：</span>
					                      <div>
					                          <input id="permission" type="text" name="permission" value="${resource.permission}" placeholder="输入权限字符串" class="add_store_inp"/>
					                      </div>
					                  </li>
				                   </ol>
			              <a href="javascript:void(0)" name="submit" onclick="document.getElementById('resource').submit();" class="btn btn_primary">${op}</a>
			        </div>
			    </form:form>
             <!-- 表格结束-->            
        </div> 	      
      </div>
</body>
</html>