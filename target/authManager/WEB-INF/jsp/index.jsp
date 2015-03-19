<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ include file="../jsp/common/resource.jsp"%>
<%@ include file="../jsp/common/tags.jsp"%>
<title>系统管理</title>
    <script src="${ctx}/static/js/index.js" type="text/javascript" ></script>	
</head>
<body> 
  <!-- 导航栏 开始-->
  	 <%@ include file="../jsp/common/nav.jsp" %>
  <!-- 导航栏 结束 -->
  <!-- 二级菜单 开始-->
   <%-- <jsp:include page="../../jsp/common/menu.jsp" 0/> --%>   
   <div class="col_wrap">
      <div class="col_side lightshadow">                        
         <iframe id="imframe" name="mymframe" src="" width="250px" height="600px" onload="changeMain();" frameborder="0" scrolling="no"></iframe>
      </div>
      <div class="col_main lightshadow" style="padding: 0px 60px 0 0;">
  		 <div class="iframe_wrap">
  		 	<iframe id="iframe" name="myframe" src="" width="863px" onload="iFrameHeight();" frameborder="0" scrolling="no"></iframe>
  		 </div>
      </div>
  </div>   
  <!-- 二级菜单 结束-->
  <!-- 底部 -->
  <jsp:include page="../jsp/common/footer.jsp" />
</body>
</html>