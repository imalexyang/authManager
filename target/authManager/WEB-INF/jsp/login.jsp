<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
<%@ include file="../jsp/common/resource.jsp"%>
<%@ include file="../jsp/common/tags.jsp"%>
<title>系统管理-登录</title>
</head>
<body class="sign_body"> 
    <div class="sign_bg">
        <div class="sign_wrap">           
            <form action="${ctx}/login" method="post" id="form">
	            <div class="sign_input_wrap"><input type="text" name="username" id="username" value="<shiro:principal/>" placeholder="输入帐号"/></div>
	            <div class="sign_input_wrap"><input type="password" name="password" id="password" placeholder="输入密码" /></div>
	            <a class="sign_a" href="javascript:void(0)" onclick="document.getElementById('form').submit();">登录</a>
	            <div class="error">${error}</div>
            </form>
        </div>
        <div id="sign_footer">
            <p>客服邮箱 imalex@163.com | 客服电话：010-88888888</p><br>Copyright  2015 北京****科技有限公司版权所有 All Rights Reserved.</div>
    </div>
</body>
</body>
</html>