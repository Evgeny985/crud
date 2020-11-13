
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

    <title>Add</title>

</head>
<body>
    <c:url value="/addD" var="department"/>

<form action="${department}" method="POST">

    <label for="departmentName">Department</label>
    <input type="text" name="name" id="departmentName">
    <input type="submit" value="Add Department">

</form>
</body>
</html>
