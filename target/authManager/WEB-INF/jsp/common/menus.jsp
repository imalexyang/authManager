<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../common/resource.jsp"%>
<%@ include file="../common/tags.jsp"%>
<script src="${ctx}/static/js/common/menus.js" type="text/javascript" ></script>	
 <div class="col_side lightshadow">
          <div class="col_side_shortcut">
              <ul class="menu" id="leftMenus">
               <c:forEach items="${menus}" var="m">	              
	               		 <li class="menu_list"><a href="${m.url}" target="myframe">${m.name}</a></li>	
				</c:forEach>
			</ul>
		</div>
</div>
     