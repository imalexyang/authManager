<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
  <div id="header">
       <div class="header_wrap">
          <ul class="nav">              
               <c:forEach items="${menus}" var="m">
	               	<c:if test="${m.parentId==1}">
	               		 <li class="list nostyle"><a href="${m.url}?pid=${m.id}" target="mymframe">${m.name}</a></li>	
	               	</c:if>			       		        
			   </c:forEach>
          </ul>
          <div class="account_wrap">
            <div class="account_name_wrap">
              <span class="account_name"><shiro:principal/><i class="triangle tri_down"></i></span>  
            </div>
            <div class="account_ul_wrap">
              <i class="triangle tri_bor2 tri_top"></i>
              <ul class="account_ul">
                <li class="account_list"><a href="user/1/changePassword" target="myframe">修改密码</a></li>
                <li class="account_list"><a href="${pageContext.request.contextPath}/logout">安全退出</a></li>
              </ul>
            </div>
          </div>
       </div>
  </div>