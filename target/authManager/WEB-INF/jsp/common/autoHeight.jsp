<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ include file="../common/resource.jsp"%>
<%@ include file="../common/tags.jsp"%>
<title>系统管理</title>   
</head>
<body>
 <iframe id="iframe" name="myframe" src="${ctx}/iframeAutoHeight" width="0" height="0" style="display: none;" ></iframe>
<script type="text/javascript">
		function sethash(){
			hashH=$("#forAutoHeight").height()+50;
		    urlC =  document.getElementById("iframe").src; //设置iframeA的src
		    document.getElementById("iframe").src=urlC+"?height="+hashH; //将高度作为参数传递
		    
		}
		window.onload=sethash;
	</script>
</body>
</html>