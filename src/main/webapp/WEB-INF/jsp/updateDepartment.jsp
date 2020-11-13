<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 08.11.2020
  Time: 17:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

    <title>Update</title>

</head>
<body>
<c:url value="/updateD" var="var"/>
<form action="${var}" method="POST">
    <input type="hidden"  value="${department.id}" name="id">
    <label for="name">Department</label>
    <input type="text" name="name" id="name">
    <input type="submit" value="Update department">
</form>
</body>
</html>
