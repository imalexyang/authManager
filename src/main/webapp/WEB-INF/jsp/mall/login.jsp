<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<%
	String ctx = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ ctx;
	request.setAttribute("ctx", ctx);
%>
<%@ include file="../../jsp/common/tags.jsp"%>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<link rel="stylesheet" href="${ctx}/static/mall/css/style.css">
<link rel="stylesheet" href="${ctx}/static/mall/css/common.css">
<link rel="stylesheet" href="${ctx}/static/mall/css/admin.css">
<link rel="stylesheet" href="${ctx}/static/mall/css/login.css">
<title>合肥百货后台管理系统</title>
</head>
<body class="bg_white">
	<!-- login start-->
	<div class="container">
		<div class="login_logo">
			<h1>公众号云平台管理系统</h1>
		</div>
		<div class="login_index">
			<ul class="login_sys_panel">
				<li class="login_sys_left"></li>
				<li class="login_sys_right"><img class="qrcode_small"
					src="${ctx}/static/mall/img/login_QRcode_s.png" alt="">
					<div class="verify_qrcode">
						<ul>
							<li><img src="${ctx}/static/mall/img/login_QRcode.jpg" alt=""><br />关注扫货邦</li>
						</ul>
					</div>
					<div class="login_form">
						<form action="${ctx}/login" method="post">
							<dl class="user_info">
								<dt>管理员登录</dt>
								<input type="hidden" name="token" id="token" />
								<dd>
									<input type="text" class="input_txt username" name="username"
										placeholder="登录名">
								</dd>
								<dd class="checking_tf pl40">请输入至少5个字符</dd>
								<dd>
									<input type="password" class="input_txt password"
										name="password" placeholder="密码">
								</dd>
								<dd class="checking_tf pl40">请输入至少6个字符</dd>
							</dl>
							<dl class="verity_code" style="display: none;">
								<dt>验证码</dt>
								<dd>
									<input type="text" class="input_txt qr_code">
								</dd>
								<dd>
									<img src="${ctx}/static/mall/img/login_auth_code.jpg">
								</dd>
								<dd>
									<a href="#">看不清，换一张</a>
								</dd>
							</dl>
							<dl class="btn_login btn_login_01 clearfix">
								<dt>
									<input type="submit" class="btn_primary" value="登录">
								</dt>
								<dd>
									<a href="#">忘记密码？</a>
								</dd>
								<dd class="checking_tf">用户验证失败</dd>
							</dl>
						</form>
					</div></li>
			</ul>
		</div>
		<div class="intel_commerce"></div>
		<div class="copyright_info">
			访问 <a href="#">扫货邦</a> <em>(010-64199055)</em> Copyright &copy; 2014
			扫货邦 版权所有 All Rights Reserved
		</div>
	</div>
	<!-- login end-->
	<script src="${ctx}/static/mall/js/jquery-1.11.1.min.js"></script>
	<script>
		$(document).ready(function() {
			$(".verify_qrcode").hide();
			$(".qrcode_small").hover(function() {
				$(".verify_qrcode").show();
			}, function() {
				$(".verify_qrcode").hide();
			});
		})
	</script>
</body>
</html>