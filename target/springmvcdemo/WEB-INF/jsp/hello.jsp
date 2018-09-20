
<%--
  Created by IntelliJ IDEA.
  User: 12526
  Date: 2018/9/20
  Time: 11:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>


    <!--
        <link rel="stylesheet" type="text/css" href="styles.css">
        -->
</head>
<body>
当前用户:${username}
<c:if test="${username!=null}">
    <a href="logout">退出</a>
</c:if>
</body>
</html>
