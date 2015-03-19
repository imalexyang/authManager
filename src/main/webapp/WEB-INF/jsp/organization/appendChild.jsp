<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/css.css">
</head>
<body>

    <form:form id="form" method="post" commandName="child">
        <form:hidden path="id"/>
        <form:hidden path="parentId"/>
        <form:hidden path="parentIds"/>

        <div class="form-group">
            <label>父节点名称：</label>
            ${parent.orgName}
        </div>

        <div class="form-group">
            <form:label path="orgName">子节点名称：</form:label>
            <form:input path="orgName"/>
        </div>

        <form:button>新增子节点</form:button>
    </form:form>
</body>
</html>