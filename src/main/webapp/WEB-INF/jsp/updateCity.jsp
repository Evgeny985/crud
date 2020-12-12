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
<c:url value="/city" var="var"/>
<form action="${city.id}" method="POST">
    <input type="hidden"  value="patch" name="_method">
    <label for="name">City</label>
    <input type="text" name="name" id="name">
    <input type="submit" value="Update city">
</form>
</body>
</html>
