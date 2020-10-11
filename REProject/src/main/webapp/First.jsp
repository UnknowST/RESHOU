<%--
  Created by IntelliJ IDEA.
  User: 123
  Date: 2020/10/9
  Time: 21:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>first</title>
</head>
<body>
<c:forEach items="${userlist}" var="user">
    <td>${user.userid}</td></br>
</c:forEach>
</body>
</html>
