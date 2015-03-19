<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <title>菜单管理</title>
    <%@ include file="../../jsp/common/resource.jsp"%>
	<%@ include file="../../jsp/common/tags.jsp"%>
	<jsp:include page="../../jsp/common/autoHeight.jsp" />
    <link rel="stylesheet" href="${ctx}/static/jquery-treetable/stylesheets/jquery.treetable.css">
    <link rel="stylesheet" href="${ctx}/static/jquery-treetable/stylesheets/jquery.treetable.theme.default.css">
	<script src="${ctx}/static/jquery-treetable/javascripts/src/jquery.treetable.js"></script>
    <style>
        #table th, #table td {
            font-size: 14px;
            padding : 8px;
        }

    </style>
    <script>
    $(function() {
        $("#table").treetable({ expandable: true }).treetable("expandNode", 1);
        $(".deleteBtn").click(function() {
            if(confirm("确认删除吗?")) {
                location.href = "${ctx}/resource/"+$(this).data("id")+"/delete";
            }
        });
        
        $(".autoIfreamHeight").click(function(){
        	$("#iframe", parent.document).height($(".col_main").height());        	
       	});
        
    });
</script>
</head>
<body>

<div class="col_main lightshadow" id="forAutoHeight">
	<h2 class="page_headline"><span class="c_blue store_title">用户列表</span></h2>
    <div class="pb50">        
		<c:if test="${not empty msg}">
		    <div class="message">${msg}</div>
		</c:if>
		<table id="table">
		    <thead>
		        <tr>
		            <th width="130px;">名称</th>
		            <th width="50px;">类型</th>
		            <th width="300px;">URL路径</th>
		            <th width="90px;">权限字符串</th>
		            <th width="100px;">操作</th>
		        </tr>
		    </thead>
		    <tbody>
		        <c:forEach items="${resourceList}" var="resource">
		            <tr data-tt-id='${resource.id}' <c:if test="${not resource.rootNode}">data-tt-parent-id='${resource.parentId}'</c:if>>
		                <td class="autoIfreamHeight"  width="130px;">${resource.name}</td>
		                <td width="50px;">${resource.type.info}</td>
		                <td width="300px;">${resource.url}</td>
		                <td width="90px;">${resource.permission}</td>
		                <td width="100px;">
		                        <c:if test="${resource.type ne 'button'}">
		                        <a href="${ctx}/resource/${resource.id}/appendChild">添加子节点</a>
		                        </c:if>
		                        <a href="${ctx}/resource/${resource.id}/update">修改</a>
		                    <c:if test="${not resource.rootNode}">
		                        <a class="deleteBtn" href="#" data-id="${resource.id}">删除</a>
		                    </c:if>
		                </td>
		            </tr>
		        </c:forEach>
		    </tbody>
		</table>
	</div>
</div>
</body>
</html>