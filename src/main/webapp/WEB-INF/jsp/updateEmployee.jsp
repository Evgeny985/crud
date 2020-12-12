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
    <title>Update Employee</title>
</head>
<body>
<c:url value="/updateEmployee" var="var"/>
<form action="${var}" method="POST">
    <input type="hidden" value="${employee.id}" name="id">
    <label for="firstName">FirstName</label>
    <input type="text" name="firstName" id="firstName">
    <label for="lastName">LastName</label>
    <input type="text" name="lastName" id="lastName">
    <label>City</label>
    <input type="text" name="cityId">
    <label>Department</label>
    <input type="text" name="departmentId">
    <input type="submit" value="Update Employee">
</form>
</body>
</html>
