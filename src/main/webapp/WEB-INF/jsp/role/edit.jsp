<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="shbfn" uri="http://www.saohuobang.com/platform/tags/shb-functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ include file="../../jsp/common/resource.jsp"%>
<%@ include file="../../jsp/common/tags.jsp"%>
<title>编辑应用管理</title>
	<link rel="stylesheet" href="${ctx}/static/JQuery zTree v3.5.15/css/zTreeStyle/zTreeStyle.css" />
    <script src="${ctx}/static/JQuery zTree v3.5.15/js/jquery.ztree.all-3.5.min.js"></script>
    <style>
        ul.ztree {margin-top: 10px;border: 1px solid #617775;background: #f0f6e4;width:220px;height:200px;overflow-y:scroll;overflow-x:auto;}
    </style>
    <script type="text/javascript">
		$(function () {
            var setting = {
                check: {
                    enable: true ,
                    chkboxType: { "Y": "", "N": "" }
                },
                view: {
                    dblClickExpand: false
                },
                data: {
                    simpleData: {
                        enable: true
                    }
                },
                callback: {
                    onCheck: onCheck
                }
            };

            var zNodes =[
                <c:forEach items="${resourceList}" var="r">
                <c:if test="${not r.rootNode}">
                { id:${r.id}, pId:${r.parentId}, name:"${r.name}", checked:${shbfn:in(role.resourceIdsList, r.id)}},
                </c:if>
                </c:forEach>
            ];

            function onCheck(e, treeId, treeNode) {
                var zTree = $.fn.zTree.getZTreeObj("tree"),
                        nodes = zTree.getCheckedNodes(true),
                        id = "",
                        name = "";
                nodes.sort(function compare(a,b){return a.id-b.id;});
                for (var i=0, l=nodes.length; i<l; i++) {
                    id += nodes[i].id + ",";
                    name += nodes[i].name + ",";
                }
                if (id.length > 0 ) id = id.substring(0, id.length-1);
                if (name.length > 0 ) name = name.substring(0, name.length-1);
                $("#resourceIds").val(id);
                $("#resourceName").val(name);
//                hideMenu();
            }

            function showMenu() {
                var cityObj = $("#resourceName");
                var cityOffset = $("#resourceName").offset();
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
        <h2 class="page_headline"><span class="c_blue store_title">编辑应用管理</span></h2>
        <div class="pb50">
          <!-- 表格开始 -->
				<form:form method="post" commandName="role">
			        <form:hidden path="id"/>
			        <form:hidden path="available"/>
			         <form:hidden path="resourceIds"/>
					<div class="add_store">
			              <ol class="add_store_ol">
			                  <li class="add_store_li">
			                      <span class="add_store_span">角色名：</span>
			                      <div>
			                          <input id="role" type="text" name="role" value="${role.role}" placeholder="输入角色名称" class="add_store_inp"/>
			                      </div>
			                  </li>
			                  <li class="add_store_li">
			                      <span class="add_store_span">角色描述：</span>
			                      <div>
			                          <input id="description" type="text" name="description" value="${role.description}" placeholder="输入角色名称" class="add_store_inp"/>
			                      </div>
			                  </li>
			                  <li class="add_store_li">
			                      <span class="add_store_span">拥有的资源列表：</span>
			                      <div>
			                          <input id="resourceName" type="text" name="resourceName" value="${shbfn:resourceNames(role.resourceIdsList)}" readonly class="add_store_inp"/>
			                      	  <a id="menuBtn" href="#">选择</a>
			                      </div>
			                  </li>
			                </ol>
			              <a href="javascript:void(0)" name="submit" onclick="document.getElementById('role').submit();" class="btn btn_primary">${op}</a>
			        </div>
			    </form:form>			
			    <div id="menuContent" class="menuContent" style="display:none; position: absolute;">
			        <ul id="tree" class="ztree" style="margin-top:0; width:160px;"></ul>
			    </div>
             <!-- 表格结束-->
        </div>
      </div>
</body>
</html>