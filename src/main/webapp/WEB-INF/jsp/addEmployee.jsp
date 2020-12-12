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
    <title>Add Employee</title>
</head>
<body>
    <c:url value="/addEmployee" var="employee"/>
<form action="${employee}"  method="POST">
    <label for="firstName">FirstName</label>
    <input type="text" name="firstName" id="firstName">
    <label for="lastName">LastName</label>
    <input type="text" name="lastName" id="lastName">
    <label >Department</label>
    <input type="text" name="departmentId">
    <input type="submit" value="Add Employee">
</form>
</body>
</html>
