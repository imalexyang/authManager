<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ include file="../../jsp/common/resource.jsp"%>
<%@ include file="../../jsp/common/tags.jsp"%>
<title>编辑用户管理</title>
	<link rel="stylesheet" href="${ctx}/static/JQuery zTree v3.5.15/css/zTreeStyle/zTreeStyle.css" />
	<script src="${ctx}/static/JQuery zTree v3.5.15/js/jquery.ztree.all-3.5.min.js"></script>
	<style>
        ul.ztree {margin-top: 10px;border: 1px solid #617775;background: #f0f6e4;width:220px;height:200px;overflow-y:scroll;overflow-x:auto;}
    </style>
    <script type="text/javascript">
		  $(function () {
            var setting = {
                view: {
                    dblClickExpand: false
                },
                data: {
                    simpleData: {
                        enable: true
                    }
                },
                callback: {
                    onClick: onClick
                }
            };

            var zNodes =[
                <c:forEach items="${organizationList}" var="o">
                    <c:if test="${not o.rootNode}">
                        { id:${o.id}, pId:${o.parentId}, name:"${o.orgName}"},
                    </c:if>
                </c:forEach>
            ];

            function onClick(e, treeId, treeNode) {
                var zTree = $.fn.zTree.getZTreeObj("tree"),
                        nodes = zTree.getSelectedNodes(),
                        id = "",
                        name = "";
                nodes.sort(function compare(a,b){return a.id-b.id;});
                for (var i=0, l=nodes.length; i<l; i++) {
                    id += nodes[i].id + ",";
                    name += nodes[i].name + ",";
                }
                if (id.length > 0 ) id = id.substring(0, id.length-1);
                if (name.length > 0 ) name = name.substring(0, name.length-1);
                $("#organizationId").val(id);
                $("#organizationName").val(name);
                hideMenu();
            }

            function showMenu() {
                var cityObj = $("#organizationName");
                var cityOffset = $("#organizationName").offset();
                $("#menuContent").css({left:cityOffset.left + "px", top:cityOffset.top + cityObj.outerHeight() + "px"}).slideDown("fast");

                $("body").bind("mousedown", onBodyDown);
            }
            function hideMenu() {
                $("#menuContent").fadeOut("fast");
                $("body").unbind("mousedown", onBodyDown);
            }
            function onBodyDown(event) {
                if (!(event.target.id == "menuBtn" || event.target.id == "menuContent" || $(event.target).parents("#menuContent").length>0)) {
                    hideMenu();
                }
            }

            $.fn.zTree.init($("#tree"), setting, zNodes);
            $("#menuBtn").click(showMenu);
        });
	</script>
</head>
<body>   
	<div class="col_main lightshadow">
        <h2 class="page_headline"><span class="c_blue store_title">编辑用户管理</span></h2>
        <div class="pb50">
             <form:form method="post" commandName="user">
				        <form:hidden path="id"/>
				        <form:hidden path="salt"/>
				        <form:hidden path="locked"/>
				 		<form:hidden path="organizationId"/>
				 		
				        <c:if test="${op ne '新增'}">
				            <form:hidden path="password"/>
				        </c:if>
             		<div class="add_store">
			              <ol class="add_store_ol">
			                  <li class="add_store_li">
			                      <span class="add_store_span">用户名：</span>
			                      <div>
			                          <input id="username" type="text" name="username" value="${user.username}" placeholder="输入用户名称" class="add_store_inp"/>
			                      </div>
			                  </li>
			                  <c:if test="${op eq '新增'}">
				                  <li class="add_store_li">
				                      <span class="add_store_span">密码：</span>
				                      <div>
				                          <input type="password" placeholder="输入密码" class="add_store_inp" id="password" name="password"/>
				                      </div>
				                  </li>
			                  </c:if>
			                  <li class="add_store_li">
			                      <span class="add_store_span">所属组织：</span>
			                      <div>
			                            <input type="text" placeholder="请选择" class="add_store_inp" id="organizationName" name="organizationName" value="${shbfn:organizationName(user.organizationId)}" readonly/>
							            <a id="menuBtn" href="#">选择</a>
							            <div id="menuContent" class="menuContent" style="display:none; position: absolute;">
									        <ul id="tree" class="ztree" style="margin-top:0; width:160px;"></ul>
									    </div>
			                      </div>
			                  </li>
			              </ol>
			              <a href="javascript:void(0)" name="submit" onclick="document.getElementById('user').submit();" class="btn btn_primary">${op}</a>
			        </div>
			        </form:form>
        </div>  
      </div>
</body>
</html>