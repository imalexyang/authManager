<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<%@ include file="../common/resource.jsp"%>
<%@ include file="../common/tags.jsp"%>
<title>系统管理</title>   
    <script type="text/javascript" >
    	function getQueryString(name) {
	        var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)", "i");
	        var r = window.location.search.substr(1).match(reg);
	        if (r != null) return unescape(r[2]); return null;
        }
	    function  pseth() {
	        var iObj = parent.parent.document.getElementById('iframe');//A和main同域，所以可以访问节点	       
	        iObj.style.height =getQueryString("height")+"px";
	    }
	    	pseth();
    </script>    
</head>
<body>
hello
</body>
</html>