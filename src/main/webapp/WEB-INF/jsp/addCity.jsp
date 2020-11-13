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
    <c:url value="/add" var="city"/>

<form action="${city}" method="POST">

    <label for="name">City</label>
    <input type="text" name="name" id="name">
    <input type="submit" value="Add City">

</form>
</body>
</html>
